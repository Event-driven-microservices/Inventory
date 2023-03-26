package com.microservices.inventory.content.product.application.service;

import com.microservices.inventory.content.product.application.service.ports.in.ProductPort;
import com.microservices.inventory.content.product.application.service.ports.out.ProductRepositoryPort;
import com.microservices.inventory.content.product.domain.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService implements ProductPort {
  @Autowired private ProductRepositoryPort productRepositoryPort;

  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public Product get(Long id) {
    return productRepositoryPort.get(id);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Product create(Product product) {
    return productRepositoryPort.create(product);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Product put(Product product) {
    return productRepositoryPort.put(product);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Product patch(Product product) {
    return productRepositoryPort.patch(product);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void delete(Long id) {
    productRepositoryPort.delete(id);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Page<Product> paged(Integer page, Integer size) {
    Pageable pageable = PageRequest.of(page, size);
    return productRepositoryPort.findAll(pageable);
  }
}
