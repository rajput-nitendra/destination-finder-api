package com.afkl.cases.df.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "auth-configs")
@Data
public class AuthConfig {
    private String clientId;
    private String clientSecret;
    private String grantType;
}
