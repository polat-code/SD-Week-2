package org.softwaredev.sdweek2.controller;

import org.softwaredev.sdweek2.model.Product;
import org.softwaredev.sdweek2.requests.ProductRequest;
import org.softwaredev.sdweek2.requests.UpdateProductRequest;
import org.softwaredev.sdweek2.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product>  getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("")
    public String addProduct(@RequestBody ProductRequest productRequest) {
        return productService.addProduct(productRequest);
    }

    @PatchMapping("")
    public String updateProduct(@RequestBody UpdateProductRequest updateProductRequest) {
        return productService.updateProduct(updateProductRequest);
    }
}
