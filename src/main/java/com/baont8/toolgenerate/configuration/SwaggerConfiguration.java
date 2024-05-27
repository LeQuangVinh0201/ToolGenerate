package com.baont8.toolgenerate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

	@Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API TOOL GENERATE")
                                 .description("API")
                                 .contact(new Contact().email("tuanbao97@gmail.com").name("Nguyen Tuan Bao"))
                                 .version("1.0"));
    }

}
