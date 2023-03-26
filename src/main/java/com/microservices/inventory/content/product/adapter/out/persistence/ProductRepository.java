package com.microservices.inventory.content.product.adapter.out.persistence;

import static com.microservices.inventory.content.product.adapter.out.persistence.entity.ProductEntityMapper.INSTANCE;

import com.microservices.inventory.content.product.application.service.ports.out.ProductRepositoryPort;
import com.microservices.inventory.content.product.domain.models.Product;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements ProductRepositoryPort {

  @Autowired private ProductJpaRepository productJpaRepository;

  @Autowired private ProductSpecJpaRepository productSpecJpaRepository;

  @Override
  public Product get(Long id) {
    return INSTANCE.toDomainModel(
        productJpaRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Product with id %d not found".formatted(id))));
  }

  @Override
  public Product create(Product product) {
    return save(product);
  }

  @Override
  public Product put(Product product) {
    get(product.getId());
    return save(product);
  }

  @Override
  public Product patch(Product product) {
    Product existingProduct = get(product.getId());
    INSTANCE.partialUpdate(product, existingProduct);
    return save(existingProduct);
  }

  @Override
  public void delete(Long id) {
    productJpaRepository.deleteById(id);
  }

  @Override
  public Page<Product> findAll(Pageable pageable) {
    return (productJpaRepository.findAll(pageable).map(INSTANCE::toDomainModel));
  }

  @Override
  public Set<Product> findAllByIdIn(List<Long> ids) {
    return productJpaRepository.findAllByIdIn(ids).stream()
        .map(INSTANCE::toDomainModel)
        .collect(Collectors.toSet());
  }

  public Product save(Product product) {
    return INSTANCE.toDomainModel(productJpaRepository.save(INSTANCE.toEntity(product)));
  }
}
