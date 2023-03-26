package com.microservices.inventory.content.product.adapter.in.rest.dtos.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimpleProductInDto {
  private Long id;
  private String productName;
  private String description;
}
