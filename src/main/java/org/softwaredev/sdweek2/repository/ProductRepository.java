package org.softwaredev.sdweek2.repository;

import org.softwaredev.sdweek2.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

  private final InMemoryProductRepository inMemoryProductRepository;

  public ProductRepository(InMemoryProductRepository inMemoryProductRepository) {
    this.inMemoryProductRepository = inMemoryProductRepository;
  }

  public List<Product> findAll() {
    return inMemoryProductRepository.getProducts();
  }

  public Product save(Product product) {
    Product foundProduct =  inMemoryProductRepository.getProducts().stream().filter(product1 ->  product1.getId().equals(product.getId())).findFirst().orElse(null);
    if(foundProduct == null) {
      int newProductId = inMemoryProductRepository.getProducts().size() + 1;
      product.setId(String.valueOf(newProductId));
      inMemoryProductRepository.getProducts().add(product);
      return product;
    }else {
      foundProduct.setName(product.getName());
      foundProduct.setPrice(product.getPrice());
    }
    return foundProduct;
  }

  public Optional<Product> findById(String id) {
    return inMemoryProductRepository.getProducts().stream()
        .filter(product -> product.getId().equals(id))
        .findFirst();
  }

  public Optional<Product> deleteProduct(String productId) {
    if(productId == null) {
      return Optional.empty();
    }
    Product foundProduct =  inMemoryProductRepository.getProducts().stream().filter(product1 ->  product1.getId().equals(productId)).findFirst().orElse(null);
    if (foundProduct != null) {
      inMemoryProductRepository.getProducts().remove(foundProduct);
      return Optional.of(foundProduct);
    }
    return Optional.empty();
  }
}
