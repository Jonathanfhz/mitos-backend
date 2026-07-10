package com.mitos.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI mitosOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Mitos API")
                        .description("REST API for managing users and relationships in Mitos.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Jonathan Ferreiro")
                                .email("jonathan@example.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub Repository")
                        .url("https://github.com/Jonathanfhz/mitos-backend"));
    }
}