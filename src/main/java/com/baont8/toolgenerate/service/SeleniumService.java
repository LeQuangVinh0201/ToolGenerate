package com.baont8.toolgenerate.service;

import org.openqa.selenium.WebDriver;

import com.baont8.toolgenerate.enumration.LanguageGoogleTranslateEnum;
import com.baont8.toolgenerate.enumration.SeleniumWebDriverEnum;

public interface SeleniumService {

	public WebDriver initDriver(SeleniumWebDriverEnum webDriverEnum);

	public String translate(String textWantToTranslate, LanguageGoogleTranslateEnum sourceLanguage, LanguageGoogleTranslateEnum targetLanguage);

}
