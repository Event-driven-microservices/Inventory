package com.microservices.inventory.content.product.adapter.out.persistence;

import com.microservices.inventory.content.product.adapter.out.persistence.entity.ProductEntity;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
  Set<ProductEntity> findAllByIdIn(List<Long> ids);
}
