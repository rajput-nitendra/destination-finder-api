package com.afkl.cases.df.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "application-endpoints")
@Data
public class ApplicationEndpoints {
    private String accessTokenUri;
    private String airportsUri;
    private String calculateFareUri;
}
