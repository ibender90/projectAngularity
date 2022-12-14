package com.geek.angularity.service;

import com.geek.angularity.model.Product;
import com.geek.angularity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
       return productRepository.getProductById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void deleteProductById(Long id) {
        productRepository.deleteProductById(id);
    }

    public void changeProductPrice(Long id, Double delta) {
        productRepository.changeProductPrice(id, delta);
    }
}
