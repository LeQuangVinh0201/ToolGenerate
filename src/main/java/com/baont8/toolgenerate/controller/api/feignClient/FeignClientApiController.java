package com.baont8.toolgenerate.controller.api.feignClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.baont8.toolgenerate.errors.InternalServerErrorException;
import com.baont8.toolgenerate.service.dtoRequest.projectCustomer.CocCocTranslateRequestDto;
import com.baont8.toolgenerate.service.dtoRequest.selenium.GoogleTranslateRequestDto;
import com.baont8.toolgenerate.service.dtoResponse.projectCustomer.CocCocTranslateResponseDto;

@RestController
public class FeignClientApiController {

	private static final String URL_API_COCCOC = "https://hoctap.coccoc.com/composer/proxyapi";

	private final Logger log = LoggerFactory.getLogger(FeignClientApiController.class);

	@Autowired
	private MessageSource messageSource;

	@PostMapping("/translate")
	public ResponseEntity<String> translateWithCocCoc(@RequestBody GoogleTranslateRequestDto requestDto,
			@RequestParam(name = "lang", defaultValue = "en") String lang) {
		String resultTranslate = null;
		try {
			// URI api coccoc
			String url = URL_API_COCCOC.concat("/translate");

			// Build query param
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
		            .queryParam("from", requestDto.getSourceLanguage().getLangName())
		            .queryParam("to", requestDto.getTargetLanguage().getLangName());

			// Create object RestTemplate
			RestTemplate restTemplate = new RestTemplate();
			// Add headers
			HttpHeaders headers = new HttpHeaders();
			headers.set("authority", "hoctap.coccoc.com");
			headers.set("accept", "*/*");
			headers.setContentType(MediaType.APPLICATION_JSON);
			// Set data request DTO
			CocCocTranslateRequestDto cocCocTranslateRequestDto = new CocCocTranslateRequestDto(requestDto.getTextWantToTranslate().replace("\\", ""));
			// Set information header and request body
			HttpEntity<CocCocTranslateRequestDto> request = new HttpEntity<>(cocCocTranslateRequestDto, headers);

			// Call API and get response restful api
			ResponseEntity<CocCocTranslateResponseDto> response = restTemplate.postForEntity(uriBuilder.toUriString(), request, CocCocTranslateResponseDto.class);

			// Check status code after restful api return
			HttpStatusCode httpStatusCode = response.getStatusCode();
			if (httpStatusCode.is2xxSuccessful() && response.getBody() != null 
					&& !CollectionUtils.isEmpty(response.getBody().getProxyApi())
					&& !CollectionUtils.isEmpty(response.getBody().getProxyApi().get(0).getTranslations())
			) {
				resultTranslate = response.getBody().getProxyApi().get(0).getTranslations().get(0).getText();
			} else {
				throw new InternalServerErrorException("Internal server error parser exception", "TRANSLATE WITH COCCOC");
			}
		} catch (Exception e) {
			System.out.println("============ MESSAGE : " + e.getMessage());
			System.out.println("============ MESSAGE : " + e.getCause().toString());
			log.debug(e.getMessage());
			log.debug(e.getCause().toString());
			throw new InternalServerErrorException("Internal server error exception", "TRANSLATE WITH COCCOC");
		}
		
		// Return api
		return ResponseEntity.ok().body(resultTranslate);
	}

}
