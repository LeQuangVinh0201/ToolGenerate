package com.baont8.toolgenerate.service.dtoRequest.selenium;

import com.baont8.toolgenerate.enumration.LanguageGoogleTranslateEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GoogleTranslateRequestDto {

	@JsonProperty(value = "TEXT_WANT_TO_TRANSLATE")
	String textWantToTranslate;

	@JsonProperty(value = "SOURCE_LANGUAGE")
	LanguageGoogleTranslateEnum sourceLanguage;

	@JsonProperty(value = "TARGET_LANGUAGE")
	LanguageGoogleTranslateEnum targetLanguage;

	public String getTextWantToTranslate() {
		return textWantToTranslate;
	}

	public void setTextWantToTranslate(String textWantToTranslate) {
		this.textWantToTranslate = textWantToTranslate;
	}

	public LanguageGoogleTranslateEnum getSourceLanguage() {
		return sourceLanguage;
	}

	public void setSourceLanguage(LanguageGoogleTranslateEnum sourceLanguage) {
		this.sourceLanguage = sourceLanguage;
	}

	public LanguageGoogleTranslateEnum getTargetLanguage() {
		return targetLanguage;
	}

	public void setTargetLanguage(LanguageGoogleTranslateEnum targetLanguage) {
		this.targetLanguage = targetLanguage;
	}

}
