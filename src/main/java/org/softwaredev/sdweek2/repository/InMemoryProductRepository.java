package org.softwaredev.sdweek2.repository;

import lombok.Getter;
import org.softwaredev.sdweek2.model.Product;

import java.util.List;

@Getter
public class InMemoryProductRepository {

  private final List<Product> products;

  public InMemoryProductRepository(List<Product> products) {
    this.products = products;
  }
}
