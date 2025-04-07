package org.softwaredev.sdweek2.service;

import org.softwaredev.sdweek2.model.Product;
import org.softwaredev.sdweek2.repository.ProductRepository;
import org.softwaredev.sdweek2.requests.ProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository  productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public String addProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .price(productRequest.price())
                .build();
        product = productRepository.save(product);
        return product.toString();
    }
}
