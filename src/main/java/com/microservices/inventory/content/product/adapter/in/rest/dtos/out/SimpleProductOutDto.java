package com.microservices.inventory.content.product.adapter.in.rest.dtos.out;

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
  private String productName;
  private String description;
}
