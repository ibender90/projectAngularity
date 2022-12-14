package com.geek.angularity.repository;

import com.geek.angularity.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productsList;

    @PostConstruct
    private void init() {
        productsList = new ArrayList<>(Arrays.asList(
                new Product(1L, "Extrella", 2.5D),
                new Product(2L, "Lays", 1.8D),
                new Product(3L, "Cheetos", 1.0D),
                new Product(4L, "Taffel", 2.7D),
                new Product(5L, "Pringles", 3.0D)
        ));
    }

    public Product getProductById(Long id) {
        return productsList.stream().filter(s -> s.getId().equals(id)).findFirst().
                orElseThrow(() -> new RuntimeException("No product found"));
    }

    public List<Product> getAllProducts() {
        return productsList;
    }

    public void deleteProductById(Long id){
        productsList.removeIf(p -> p.getId().equals(id));
    }

    public void changeProductPrice(Long id, Double delta) {
        Product product = getProductById(id);
        product.setPrice(product.getPrice() + delta);
    }
}
