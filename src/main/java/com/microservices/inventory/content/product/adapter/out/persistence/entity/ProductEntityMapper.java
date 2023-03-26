package com.microservices.inventory.content.product.adapter.out.persistence.entity;

import com.microservices.inventory.content.product.domain.models.Product;
import com.microservices.inventory.shared.CycleAvoidingMappingContext;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductEntityMapper {
  ProductEntityMapper INSTANCE = Mappers.getMapper(ProductEntityMapper.class);
  CycleAvoidingMappingContext DEFAULT_CONTEXT = new CycleAvoidingMappingContext();

  @Named("toEntityWithContext")
  ProductEntity toEntityWithContext(Product Product, @Context CycleAvoidingMappingContext context);

  @Named("toDomainWithContext")
  Product toDomainWithContext(
      ProductEntity ProductEntity, @Context CycleAvoidingMappingContext mappingContext);

  @BeanMapping(
      nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
      nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
  @Mapping(target = "id", ignore = true)
  void partialUpdate(Product newProduct, @MappingTarget Product Product);

  default Product toDomainModel(ProductEntity ProductEntity) {
    return toDomainWithContext(ProductEntity, DEFAULT_CONTEXT);
  }

  default ProductEntity toEntity(Product Product) {
    return toEntityWithContext(Product, DEFAULT_CONTEXT);
  }
}
