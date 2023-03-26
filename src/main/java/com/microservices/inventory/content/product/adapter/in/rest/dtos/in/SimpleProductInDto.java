package com.microservices.inventory.content.product.adapter.in.rest.dtos.in;

import com.fasterxml.jackson.databind.JsonNode;
import com.project.lowcode.shared.enums.MethodType;
import com.project.lowcode.validations.abstraction.CreateValidationGroup;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimpleProductInDto {
  private String acceptCharset;
  private String acceptHeader;
  private String authType;
  private String authUrl;
  private String connectTimeout;
  private String content;
  private String contentData;
  private String contentType;
  private String contentTypeCharset;
  private String handleResponseErrors;
  private String headers;
  private String password;
  private String readTimeout;
  private String resultClass;
  private String username;
  private String description = "Default description";
  private String body;
  private JsonNode input;
  private JsonNode output;

  @NotNull(groups = CreateValidationGroup.class)
  private String route;

  @NotNull(groups = CreateValidationGroup.class)
  private MethodType method;
}
