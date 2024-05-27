package com.baont8.toolgenerate.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.baont8.toolgenerate.configuration.CurrentDateConfiguration;
import com.baont8.toolgenerate.configuration.FileStoragePropertiesConfiguration;
import com.baont8.toolgenerate.enumration.YesNoEnum;
import com.baont8.toolgenerate.service.CommonService;
import com.baont8.toolgenerate.service.dto.common.YesNoTypeDto;
import com.baont8.toolgenerate.service.dtoResponse.common.GetYesNoTypesResponseDto;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CurrentDateConfiguration currentDateConfiguration;

	private final Path fileStorageLocation;

	public CommonServiceImpl(FileStoragePropertiesConfiguration fileStorageProperties) {
		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir() != null ? fileStorageProperties.getUploadDir() : "C:/tool-generate-upload").toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {}
	}

	@Override
	public String convertParagraphTo1LineWithSpecialCharacter(String sourceString) {
		if (sourceString == null) {
			return null;
		}
		// Replace new line to \n, r carriage return to \r, t table to \n
		return sourceString.replaceAll("\\n", "\\\\n").replaceAll("\\r", "\\\\r").replaceAll("\\t", "\\\\t").replaceAll("\\u00a0"," ");
	}

	@Override
	public String convert1LineToParagraph(String sourceString) {
		if (sourceString == null) {
			return null;
		}
		return sourceString.replaceAll("\\\\n", "\n").replaceAll("\\\\r", "\r").replaceAll("\\\\t", "\t").replaceAll("\\u00a0"," ");
	}

	@Override
	public Boolean checkStringIsBoolean(String stringBoolean) {
		if (stringBoolean == null) {
			return false;
		}else if ("true".equalsIgnoreCase(stringBoolean) || "false".equalsIgnoreCase(stringBoolean)) {
	        return true;
	    } else {
	        return false;
	    }
	}

	@Override
	public String buildAndSaveFileString(String fileNameWithExtension, String fileContent) throws IOException {
		// Copy file to location (replace file if exists)
        Path targetLocation = this.fileStorageLocation.resolve(currentDateConfiguration.informationDateSaveFile());
        Path targetLocationFile = targetLocation.resolve(fileNameWithExtension);

        // Create a directory to saving file
        if (!Files.exists(targetLocation)) {
            try {
                Files.createDirectories(targetLocation);
            } catch (IOException e) {
                // fail to create directory
            }
        }
        InputStream stream = new ByteArrayInputStream(fileContent.getBytes(StandardCharsets.UTF_8));
        Files.copy(stream, targetLocationFile, StandardCopyOption.REPLACE_EXISTING);

        return targetLocationFile.toAbsolutePath().toString()
            	.replace(fileStorageLocation.toAbsolutePath().toString(), StringUtils.EMPTY);
	}

	@Override
	public Resource loadFileAsResource(String pathFile) {
		// Get path
        Path filePath = this.fileStorageLocation.resolve(pathFile.substring(1, pathFile.length())).normalize();
        Resource resource = null;
        try {
            // Get resource by path
            resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
//                throw new NotFoundException(apiMessageResponse.dataNotExists,
//                        EntityNameConstrant.ENTITY_NAME_DOCUMENT_STORAGE);
            }
        } catch (Exception e) {
//            throw new NotFoundException(apiMessageResponse.dataNotExists,
//                    EntityNameConstrant.ENTITY_NAME_DOCUMENT_STORAGE);
        }
		return resource;
	}

	@Override
	public GetYesNoTypesResponseDto getYesNoTypes() {
		List<YesNoTypeDto> ynTypes = new ArrayList<>();
		// Looping stream enums
		Arrays.asList(YesNoEnum.values()).stream().forEach(item -> {
			YesNoTypeDto yesNoTypeDto = new YesNoTypeDto();
			yesNoTypeDto.setYnType(item.name());
			yesNoTypeDto.setYnDesc(item.getText());
			yesNoTypeDto.setYnValue(item.isValue());
			ynTypes.add(yesNoTypeDto);
		});
		GetYesNoTypesResponseDto getYesNoTypesResponseDto = new GetYesNoTypesResponseDto();
		getYesNoTypesResponseDto.setYnTypes(ynTypes);
		return getYesNoTypesResponseDto;
	}

	@Override
	public String urlEncode(String text) {
		if (StringUtils.isBlank(text)) {
			return null;
		}
		try {
			return URLEncoder.encode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

}
