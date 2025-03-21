package org.softwaredev.sdweek2.repository;

import org.softwaredev.sdweek2.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

  private final InMemoryProductRepository inMemoryProductRepository;

  public ProductRepository(InMemoryProductRepository inMemoryProductRepository) {
    this.inMemoryProductRepository = inMemoryProductRepository;
  }

  public List<Product> findAll() {
    return inMemoryProductRepository.getProducts();
  }
}
