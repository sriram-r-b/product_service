package org.example.first_api.services;

import org.example.first_api.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProduct(long id);
    public List<Product> getProducts();
}
