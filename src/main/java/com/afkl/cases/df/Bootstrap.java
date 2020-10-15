package com.afkl.cases.df;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
/*import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;*/
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
@ConfigurationPropertiesScan("com.afkl.cases.df.config.*")
public class Bootstrap {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Bootstrap.class, args);
    }

}
