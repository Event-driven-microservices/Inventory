package com.microservices.inventory.content.product.adapter.in.rest.dtos;

import com.microservices.inventory.content.product.adapter.in.rest.dtos.in.ProductInDto;
import com.microservices.inventory.content.product.adapter.in.rest.dtos.in.SimpleProductInDto;
import com.microservices.inventory.content.product.adapter.in.rest.dtos.out.ProductOutDto;
import com.microservices.inventory.content.product.domain.models.Product;
import com.microservices.inventory.shared.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductDtoMapper {
  ProductDtoMapper INSTANCE = Mappers.getMapper(ProductDtoMapper.class);
  CycleAvoidingMappingContext DEFAULT_CONTEXT = new CycleAvoidingMappingContext();

  @Named("toDomainWithContext")
  Product toDomainWithContext(
      ProductInDto product, @Context CycleAvoidingMappingContext mappingContext);

  @Named("toDtoWithContext")
  ProductOutDto toDtoWithContext(Product product, @Context CycleAvoidingMappingContext context);

  @Named("toDomainWithContext")
  Product toDomainWithContext(
      SimpleProductInDto product, @Context CycleAvoidingMappingContext mappingContext);

  default Product toDomainModel(Long id, ProductInDto product) {
    return toDomainWithContext(product, DEFAULT_CONTEXT);
  }

  default ProductOutDto toDto(Product product) {
    return toDtoWithContext(product, DEFAULT_CONTEXT);
  }

  default Product toDomainModel(ProductInDto product) {
    return toDomainWithContext(product, DEFAULT_CONTEXT);
  }

  default Product toDomainModel(Long id, SimpleProductInDto product) {
    return toDomainWithContext(product, DEFAULT_CONTEXT);
  }
}
