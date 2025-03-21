package org.softwaredev.sdweek2.config;

import org.softwaredev.sdweek2.model.Product;
import org.softwaredev.sdweek2.repository.InMemoryProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public InMemoryProductRepository inMemoryProductRepository() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("1", "Apple iPhone 12", 799.99));
        products.add(new Product("2", "Samsung Galaxy S21", 699.99));
        products.add(new Product("3", "Google Pixel 5", 599.99));
        products.add(new Product("4", "Sony WH-1000XM4 Headphones", 349.99));
        products.add(new Product("5", "Dell XPS 13 Laptop", 999.99));
        products.add(new Product("6", "Apple MacBook Pro 13", 1299.99));
        products.add(new Product("7", "HP Envy Printer", 199.99));
        products.add(new Product("8", "Logitech MX Master 3 Mouse", 99.99));
        products.add(new Product("9", "Apple iPad Air", 599.99));
        products.add(new Product("10", "Samsung Galaxy Tab S7", 649.99));
        products.add(new Product("11", "Amazon Echo Dot", 49.99));
        products.add(new Product("12", "Google Nest Thermostat", 129.99));
        products.add(new Product("13", "Sony PlayStation 5", 499.99));
        products.add(new Product("14", "Microsoft Xbox Series X", 499.99));
        products.add(new Product("15", "Nintendo Switch", 299.99));
        products.add(new Product("16", "Bose QuietComfort 35 II", 299.99));
        products.add(new Product("17", "Apple Watch Series 6", 399.99));
        products.add(new Product("18", "Fitbit Versa 3", 229.95));
        products.add(new Product("19", "Canon EOS Rebel T7 DSLR Camera", 449.99));
        products.add(new Product("20", "DJI Mavic Air 2 Drone", 799.00));

        return new InMemoryProductRepository(products);
    }
}
