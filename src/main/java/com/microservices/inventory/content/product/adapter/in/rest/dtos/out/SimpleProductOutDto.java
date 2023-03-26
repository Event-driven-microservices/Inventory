package com.microservices.inventory.content.product.adapter.in.rest.dtos.out;

import com.fasterxml.jackson.databind.JsonNode;
import com.project.lowcode.shared.enums.MethodType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimpleProductOutDto {
  private Long id;
  private Long externalApiId;
  private String tenantId;
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
  private String route;
  private String username;
  private String description;
  private String summary;
  private String body;
  private JsonNode input;
  private JsonNode output;
  private MethodType method;
}