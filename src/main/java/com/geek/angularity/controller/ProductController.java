package com.geek.angularity.controller;

import com.geek.angularity.model.Product;
import com.geek.angularity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> showAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product showProduct(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @GetMapping("/change_price")
    public void changeProductPrice(@RequestParam Long productId, @RequestParam Double delta){
        productService.changeProductPrice(productId, delta);
    }
}
