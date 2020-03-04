package com.simonblund.rest.webservices.incidentapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.service.ApiInfo.*;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final Contact DEFAULT_CONTACT = new Contact("SimonBlund", "simonblund.com", "sites+D3@simonblund.com");
    public static final ApiInfo API_INCIDENT = new ApiInfo(
            "Api documentation",
            "Api Documentation",
            "1.0.0",
            "urn:tos",
            DEFAULT_CONTACT.toString(),
            "Apache 2.0",
            "" );

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT);
    }

}
