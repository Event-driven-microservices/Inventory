package com.microservices.inventory.swagger;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {

  @GetMapping(value = "/")
  @Operation(summary = "Redirect to Swagger URL.")
  public void redirect(final HttpServletResponse response) throws IOException {
    response.sendRedirect("/api/swagger-ui/index.html");
  }

  @GetMapping(value = "/api/")
  @Operation(summary = "Redirect to Swagger URL.")
  public void redirectApi(final HttpServletResponse response) throws IOException {
    response.sendRedirect("/api/swagger-ui/index.html");
  }
}
