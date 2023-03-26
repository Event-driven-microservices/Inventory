package com.microservices.inventory.content.product.application.service.ports.in;

import com.microservices.inventory.content.product.domain.models.Product;
import org.springframework.data.domain.Page;

public interface ProductPort {
  Product get(Long id);

  Product create(Product product);

  Product put(Product product);

  Product patch(Product product);

  void delete(Long id);

  Page<Product> paged(Integer page, Integer size);
}
