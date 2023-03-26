package com.microservices.inventory.content.product.application.service.ports.out;

import com.microservices.inventory.content.product.domain.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepositoryPort {
  Product get(Long id);

  Product create(Product Product);

  Product put(Product Product);

  Product patch(Product Product);

  void delete(Long id);

  Page<Product> findAll(Pageable pageable);
}
