package com.baont8.toolgenerate.service.impl;

import java.io.File;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.baont8.toolgenerate.configuration.FileStoragePropertiesConfiguration;
import com.baont8.toolgenerate.enumration.LanguageGoogleTranslateEnum;
import com.baont8.toolgenerate.enumration.SeleniumWebDriverEnum;
import com.baont8.toolgenerate.errors.BadRequestException;
import com.baont8.toolgenerate.interceptor.ApiMessageInterceptor;
import com.baont8.toolgenerate.service.CommonService;
import com.baont8.toolgenerate.service.SeleniumService;

import io.github.bonigarcia.wdm.WebDriverManager;

@Service
public class SeleniumServiceImpl implements SeleniumService {

	private final Logger log = LoggerFactory.getLogger(SeleniumServiceImpl.class);

	@Autowired
	private FileStoragePropertiesConfiguration fileStorageProperties;

	@Autowired
	private CommonService commonService;

	@Autowired
	private MessageSource messageSource;

	private static final String URL_GOOGLE_TRANSLATE = "https://translate.google.com/?sl=${SOURCE_LANGUAGE}&tl=${TO_LANGUAGE}&text=${TEXT_WANT_TO_TRANSLATE}&op=translate";

	@Override
	public WebDriver initDriver(SeleniumWebDriverEnum webDriverEnum) {
		WebDriver driver = null;
		File profile = new File(fileStorageProperties.getHeThong().concat("/selenium-profile"));
		switch (webDriverEnum) {
		case EDGE: {
			// Version là version chrome trên máy tính của bạn
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-gpu");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			// options.addArguments("--user-data-dir=" + profile.getAbsolutePath());

			driver = new EdgeDriver(options);
			break;
		}
		case CHROME: {
			// Version là version chrome trên máy tính của bạn
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			// Hiển thị full chrome

			// options.addArguments("--headless");     
			 
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-gpu");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			// options.addArguments("--user-data-dir=" + profile.getAbsolutePath());

			driver = new ChromeDriver(options);
			break;
		}
		case FIREFOX: {
			// Version là version chrome trên máy tính của bạn
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-gpu");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			// options.addArguments("--user-data-dir=" + profile.getAbsolutePath());

			driver = new FirefoxDriver(options);
			break;
		}
		default:
		}
		return driver;
	}

	@Override
	public String translate(String textWantToTranslate, LanguageGoogleTranslateEnum sourceLanguage,
			LanguageGoogleTranslateEnum targetLanguage) {
		if (StringUtils.isBlank(textWantToTranslate) || sourceLanguage == null || targetLanguage == null) {
			throw new BadRequestException(messageSource.getMessage("data_required", new Object[] {"REQUEST_DTO"},  new Locale(ApiMessageInterceptor.langCode)),
                    "GENERATE LABEL", "REQUEST_DTO");
		}
		// Khởi tạo web với driver nào
		WebDriver webDriver = initDriver(SeleniumWebDriverEnum.CHROME);
		webDriver.get(buildUrlTranslate(textWantToTranslate, sourceLanguage, targetLanguage));

		WebDriverWait wait = new WebDriverWait(webDriver, java.time.Duration.ofSeconds(10));

		// Chờ đợi dịch xong
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("HwtZe")));
		String outputText = webDriver.findElement(By.className("HwtZe")).getText();
		log.info(" == outputText == " + outputText);

		// Tắt trình duyệt
		webDriver.quit();
		return outputText;
	}

	private String buildUrlTranslate(String textWantToTranslate, LanguageGoogleTranslateEnum sourceLanguage,
			LanguageGoogleTranslateEnum targetLanguage) {
		String textWantToTranslateEncodeURI = commonService.urlEncode(textWantToTranslate);
		// Replace parameters
		StringBuilder stringBuilder = new StringBuilder(
				URL_GOOGLE_TRANSLATE.replace("${SOURCE_LANGUAGE}", sourceLanguage.getLangName())
									.replace("${TO_LANGUAGE}", targetLanguage.getLangName())
									.replace("${TEXT_WANT_TO_TRANSLATE}", textWantToTranslateEncodeURI)
		);
		return stringBuilder.toString();
	}

}
