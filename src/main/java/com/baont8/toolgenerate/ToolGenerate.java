package com.baont8.toolgenerate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.baont8.toolgenerate.configuration.FileStoragePropertiesConfiguration;

@SpringBootApplication
@EnableConfigurationProperties({FileStoragePropertiesConfiguration.class})
public class ToolGenerate {

	public static void main(String[] args) {
		SpringApplication.run(ToolGenerate.class, args);
	}

}
