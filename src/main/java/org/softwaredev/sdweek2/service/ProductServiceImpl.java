package org.softwaredev.sdweek2.service;

import org.softwaredev.sdweek2.model.Product;
import org.softwaredev.sdweek2.repository.ProductRepository;
import org.softwaredev.sdweek2.requests.ProductRequest;
import org.softwaredev.sdweek2.requests.UpdateProductRequest;
import org.softwaredev.sdweek2.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public String addProduct(ProductRequest productRequest) {
    Product product =
        Product.builder().name(productRequest.name()).price(productRequest.price()).build();
    product = productRepository.save(product);
    return product.toString();
  }

  @Override
  public String updateProduct(UpdateProductRequest updateProductRequest) {
    Optional<Product> optionalProduct = productRepository.findById(updateProductRequest.id());
    if (optionalProduct.isEmpty()) {
      return "There  is no product with id: " + updateProductRequest.id();
    }
    Product product = optionalProduct.get();
    product.setName(updateProductRequest.name());
    product.setPrice(updateProductRequest.price());
    product = productRepository.save(product);
    return product.toString();
  }

  @Override
  public String deleteProduct(String productId) {
    Optional<Product> optionalProduct = productRepository.deleteProduct(productId);
    if (optionalProduct.isEmpty()) {
      return "There  is no product with id: " + productId;
    }
    Product product = optionalProduct.get();
    return product + " is deleted successfully";
  }

  @Override
  public List<ProductResponse> filterProducts(Double minPrice, Double maxPrice, String productId) {
    if (productId != null) {
      return productRepository.findAll().stream()
          .filter(product -> product.getId().equals(productId))
          .map(
              product ->
                  ProductResponse.builder()
                      .id(product.getId())
                      .name(product.getName())
                      .price(product.getPrice())
                      .build())
          .collect(Collectors.toList());
    }
    return productRepository.findAll().stream()
            .filter(product -> {
              // Apply minimum price check if needed.
              if (minPrice != null && product.getPrice() < minPrice) {
                return false;
              }
              // Apply maximum price check if needed.
              if (maxPrice != null && product.getPrice() > maxPrice) {
                return false;
              }
              return true;
            })
            .map(product -> ProductResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .build())
            .collect(Collectors.toList());

  }
}
