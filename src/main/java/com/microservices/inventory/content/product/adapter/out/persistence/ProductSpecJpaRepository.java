package com.microservices.inventory.content.product.adapter.out.persistence;

import com.project.lowcode.content.app.appConfig.Product.adapter.out.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSpecJpaRepository
    extends PagingAndSortingRepository<ProductEntity, String>,
        JpaSpecificationExecutor<ProductEntity> {}
