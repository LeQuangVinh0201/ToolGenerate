package com.baont8.toolgenerate.configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * class CurrentDateConfiguration
 * @author nhatmq
 * @since 1.0
 * @created 24/12/2019 22:03:04
 */
@Component
public class CurrentDateConfiguration {

    public String date() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String year() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String month() {
        DateFormat dateFormat = new SimpleDateFormat("MM");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String informationDateSaveFile() {
        return year() + "/" + month() + "/" + date();
    }
}
