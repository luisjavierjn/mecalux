package com.mecalux.test.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
            .info(new Info()
                    .title("Prueba Técnica DMT")
                    .version("1.0")
                    .description("Aplicación SPA con Angular y un API Rest con Spring Boot.")
            );
  }
}
