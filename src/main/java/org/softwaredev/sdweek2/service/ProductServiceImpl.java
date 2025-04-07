package org.softwaredev.sdweek2.service;

import org.softwaredev.sdweek2.model.Product;
import org.softwaredev.sdweek2.repository.ProductRepository;
import org.softwaredev.sdweek2.requests.ProductRequest;
import org.softwaredev.sdweek2.requests.UpdateProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public String updateProduct(UpdateProductRequest updateProductRequest) {
        Optional<Product> optionalProduct = productRepository.findById(updateProductRequest.id());
        if(optionalProduct.isEmpty()) {
            return "There  is no product with id: " + updateProductRequest.id();
        }
        Product product = optionalProduct.get();
        product.setName(updateProductRequest.name());
        product.setPrice(updateProductRequest.price());
        product =   productRepository.save(product);
        return  product.toString();
    }
}
