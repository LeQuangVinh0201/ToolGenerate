package com.baont8.toolgenerate.controller.api.generateTool.fileTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.baont8.toolgenerate.constrant.PageableConstrants;
import com.baont8.toolgenerate.constrant.SortConstrants;
import com.baont8.toolgenerate.enumration.StatusEnum;
import com.baont8.toolgenerate.service.FileTemplateService;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.GenerateFileTemplateRequestDto;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.GetFileTemplateRequestDto;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.GetListFileTemplateRequestDto;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.SaveFileTemplateRequestDto;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.SetFileSystemRequestDto;
import com.baont8.toolgenerate.service.dtoResponse.fileTemplate.GetFileTemplateResponseDto;
import com.baont8.toolgenerate.service.dtoResponse.fileTemplate.GetListFileTemplateResponseDto;
import com.baont8.toolgenerate.service.dtoResponse.fileTemplate.SaveFileTemplateResponseDto;
import com.baont8.toolgenerate.utils.PaginationUtil;
import com.baont8.toolgenerate.utils.Paging;

import jakarta.validation.Valid;

@RestController
public class FileTemplateApiController {

	@Autowired
	private FileTemplateService fileTemplateService;

	@PostMapping("/save-file-template")
	public ResponseEntity<SaveFileTemplateResponseDto> saveFileTemplate(@RequestBody @Valid SaveFileTemplateRequestDto requestDto,
			@RequestParam(name = "lang", defaultValue = "en") String lang) {
		SaveFileTemplateResponseDto saveFileTemplateResponseDto = fileTemplateService.saveFileTemplate(requestDto);
		return ResponseEntity.ok().body(saveFileTemplateResponseDto);
	}

	@GetMapping("/get-file-template/{fileTemplateId}")
	public ResponseEntity<GetFileTemplateResponseDto> getFileTemplate(
			@PathVariable(name = "fileTemplateId") Integer fileTemplateId,
			@RequestParam(name = "lang", defaultValue = "en") String lang) {
		GetFileTemplateRequestDto requestDto = new GetFileTemplateRequestDto();
		requestDto.setFileTemplateId(fileTemplateId);
		return ResponseEntity.ok().body(fileTemplateService.getFileTemplateById(requestDto));
	}

	@PostMapping("/generate-file-template")
	public ResponseEntity<Resource> generateFileTemplate(@RequestBody @Valid GenerateFileTemplateRequestDto requestDto,
			@RequestParam(name = "lang", defaultValue = "en") String lang) {
		Resource resource = fileTemplateService.generateFileTemplate(requestDto);
		HttpHeaders headers = new HttpHeaders();
		headers.set("FILE-NAME", resource.getFilename());
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/octet-stream"))
                .headers(headers)
                .body(resource);
	}

	@PostMapping("/generate-file-template-to-string")
	public ResponseEntity<String> generateFileTemplateToString(@RequestBody @Valid GenerateFileTemplateRequestDto requestDto,
			@RequestParam(name = "lang", defaultValue = "en") String lang) {
		return ResponseEntity.ok().body(fileTemplateService.generateFileTemplateToString(requestDto));
	}

	@GetMapping("/get-list-file-template")
	public ResponseEntity<Paging<GetListFileTemplateResponseDto>> getListFileTemplate(
			@PageableDefault(size = PageableConstrants.DEFAULT_SIZE, page = PageableConstrants.DEFAULT_PAGE, sort = {
                    SortConstrants.CREATED_DATE_NATIVE }, direction = Direction.DESC) Pageable pageable,
			@RequestParam(name = "size", required = false) Integer sizeCheckShowAll,
			@RequestParam(name = "status", required = false, defaultValue = "USING") StatusEnum status,
			@RequestParam(name = "lang", defaultValue = "en") String lang) {
		GetListFileTemplateRequestDto requestDto = new GetListFileTemplateRequestDto();
		requestDto.setSizeCheckShowAll(sizeCheckShowAll);
		requestDto.setPageable(pageable);
		requestDto.setStatus(status);
		Page<GetListFileTemplateResponseDto> pageListFileTemplate = fileTemplateService.getListFileTemplate(requestDto);
		HttpHeaders headers = PaginationUtil
                .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), pageListFileTemplate);

		
		return new ResponseEntity<>(PaginationUtil.generatePage(pageListFileTemplate), headers, HttpStatus.OK);
	}

	@DeleteMapping("/delete-file-template/{fileTemplateId}")
	public ResponseEntity<Void> deleteFileTemplate(@PathVariable(name = "fileTemplateId", required = false) Integer fileTemplateId,
			@RequestParam(name = "lang", defaultValue = "en") String lang) {
		fileTemplateService.deleteFileTemplate(fileTemplateId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/set-system-file-template/{fileTemplateId}")
	public ResponseEntity<Void> setSystemFileTemplatge(@Valid @RequestBody SetFileSystemRequestDto requestDto,
			@PathVariable(name = "fileTemplateId", required = false) Integer fileTemplateId,
			@RequestParam(name = "lang", defaultValue = "en") String lang) {
		requestDto.setFileTemplateId(fileTemplateId);
		fileTemplateService.setFileSystem(requestDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
