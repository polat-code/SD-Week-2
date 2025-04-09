package org.softwaredev.sdweek2.service;

import org.softwaredev.sdweek2.model.Product;
import org.softwaredev.sdweek2.requests.ProductRequest;
import org.softwaredev.sdweek2.requests.UpdateProductRequest;
import org.softwaredev.sdweek2.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    String addProduct(ProductRequest productRequest);

    String updateProduct(UpdateProductRequest updateProductRequest);

    String deleteProduct(String productId);

    List<ProductResponse> filterProducts( Double minPrice, Double maxPrice, String productId);
}
