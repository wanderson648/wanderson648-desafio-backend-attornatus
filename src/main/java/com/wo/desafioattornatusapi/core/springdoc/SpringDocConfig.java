package com.wo.desafioattornatusapi.core.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Backend na Attornatus\n" +
                                "Procuradoria Digital")
                        .version("v1")
                        .description("REST API Attornatus")
                );

    }
}
