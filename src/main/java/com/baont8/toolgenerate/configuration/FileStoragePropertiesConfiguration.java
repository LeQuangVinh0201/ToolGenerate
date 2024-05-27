package com.baont8.toolgenerate.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
* class FileStoragePropertiesConfiguration
* @author nhatmq
* @since 1.0
* @created 24/12/2019 22:08:01
*/
@ConfigurationProperties(prefix = "file")
public class FileStoragePropertiesConfiguration {

    private String uploadDir;

    private String heThong;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    public String getHeThong() {
        return heThong;
    }

    public void setHeThong(String heThong) {
        this.heThong = heThong;
    }

}
