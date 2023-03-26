package com.microservices.inventory.content.product.adapter.out.persistence.entity;

import static jakarta.persistence.GenerationType.SEQUENCE;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mstr_product")
public class ProductEntity {
  @Id
  @GeneratedValue(strategy = SEQUENCE, generator = "product_sequence")
  private Long id;

  @Column(name = "product_name")
  private String productName;

  @Column(name = "description")
  private String description;

  @PrePersist
  @PreUpdate
  public void prePersist() {}

  @PostLoad
  @PostUpdate
  @PostPersist
  public void postLoad() {}
}
