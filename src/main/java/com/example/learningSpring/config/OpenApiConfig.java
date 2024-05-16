package com.example.learningSpring.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Shirali Alihummatov
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("learning spring service")
                        .description("for learning spring framework"))
                .externalDocs(new ExternalDocumentation()
                        .description("no documentation")
                        .url("url"));
    }

}
