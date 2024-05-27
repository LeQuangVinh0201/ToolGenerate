package com.baont8.toolgenerate.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DirectoryFileConfig implements WebMvcConfigurer {

    @Autowired
    private FileStoragePropertiesConfiguration fileStoragePropertiesConfiguration;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/file/**")
                .addResourceLocations("file:" + fileStoragePropertiesConfiguration.getUploadDir().concat("/"));
    }

}
