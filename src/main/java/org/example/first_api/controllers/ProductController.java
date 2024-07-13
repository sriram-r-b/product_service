package org.example.first_api.controllers;

import org.example.first_api.models.Product;
import org.example.first_api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @RequestMapping("/{id}")
    public Product getProduct(@PathVariable("id") long id){



        return productService.getProduct(id);
    }
    @RequestMapping("/all")
    public List<Product> getProducts() {
        return productService.getProducts();
    }
}
