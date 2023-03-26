package com.microservices.inventory.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local")
@Configuration
public class SwaggerLocalConfiguration {

  /**
   * Generate an API with information of it.
   *
   * @return OpenAPI
   */
  public OpenAPI openApi() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Lowcode API")
                .description("Lowcode API")
                .version("v1.0")
                .contact(null)
                .termsOfService("TOC")
                .license(new License().name("License").url("#")));
  }

  /**
   * Generate a group which you can use the distinct product of the class specified.
   *
   * @return GroupedOpenApi.
   */
  @Bean
  public GroupedOpenApi product() {
    return GroupedOpenApi.builder()
        .group("Storage")
        .packagesToScan("com.microservices.inventory")
        .build();
  }
}
