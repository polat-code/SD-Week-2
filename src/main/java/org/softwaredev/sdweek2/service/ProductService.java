package org.softwaredev.sdweek2.service;

import org.softwaredev.sdweek2.model.Product;
import org.softwaredev.sdweek2.requests.ProductRequest;
import org.softwaredev.sdweek2.requests.UpdateProductRequest;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    String addProduct(ProductRequest productRequest);

    String updateProduct(UpdateProductRequest updateProductRequest);

    String deleteProduct(String productId);
}
