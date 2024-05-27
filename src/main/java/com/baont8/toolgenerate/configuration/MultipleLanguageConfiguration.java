package com.baont8.toolgenerate.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.baont8.toolgenerate.interceptor.ApiMessageInterceptor;

@Configuration
public class MultipleLanguageConfiguration implements WebMvcConfigurer {

    @Bean(name = "messageSource")
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();

        // Read properties start with language_...
        messageResource.setBasename("classpath:multiple-languages/language");
        messageResource.setDefaultEncoding("UTF-8");
        return messageResource;
    }

    // Register bean Interceptor to @Autowired trong Interceptor
    @Bean
    public ApiMessageInterceptor globalMessageInterceptor() {
        return new ApiMessageInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(globalMessageInterceptor()).addPathPatterns("/**");
    }

}
