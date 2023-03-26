package com.microservices.inventory.content.product.adapter.in.rest;

import static com.microservices.inventory.content.product.adapter.in.rest.dtos.ProductDtoMapper.*;

import com.microservices.inventory.content.product.adapter.in.rest.dtos.in.ProductInDto;
import com.microservices.inventory.content.product.adapter.in.rest.dtos.in.SimpleProductInDto;
import com.microservices.inventory.content.product.adapter.in.rest.dtos.out.ProductOutDto;
import com.microservices.inventory.content.product.adapter.in.rest.dtos.out.SimpleProductOutDto;
import com.microservices.inventory.content.product.application.service.ports.in.ProductPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@Tag(name = "Product")
@RequestMapping("api/product")
public class ProductController {
  @Autowired private ProductPort productPort;

  @GetMapping("{id}")
  @Operation(summary = "Get a Product entity.")
  public ProductOutDto get(@PathVariable Long id) {
    return INSTANCE.toDto(productPort.get(id));
  }

  @PostMapping
  @Operation(summary = "Create a Product entity.")
  public ProductOutDto create(@RequestBody ProductInDto product) {
    return INSTANCE.toDto(productPort.create(INSTANCE.toDomainModel(product)));
  }

  @PutMapping("{id}")
  @Operation(summary = "Update a Product entity entirely, not ignoring null values.")
  public SimpleProductOutDto put(
      @PathVariable Long id, @RequestBody @Valid SimpleProductInDto product) {
    return INSTANCE.toDto(productPort.put(INSTANCE.toDomainModel(id, product)));
  }

  @PatchMapping("{id}")
  @Operation(summary = "Update a Product entity partially, ignoring null values.")
  public SimpleProductOutDto patch(
      @PathVariable Long id, @RequestBody @Valid SimpleProductInDto product) {
    return INSTANCE.toDto(productPort.patch(INSTANCE.toDomainModel(id, product)));
  }

  @DeleteMapping("{id}")
  @Operation(summary = "Delete a Product entity.")
  public void delete(@PathVariable Long id) {
    productPort.delete(id);
  }

  @GetMapping("paged")
  @Operation(summary = "Page a Product entity.")
  public Page<ProductOutDto> paged(Integer page, Integer size) {
    return productPort.paged(page, size).map(INSTANCE::toDto);
  }
}
