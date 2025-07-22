package com.example.rest_jpa.services;

import com.example.rest_jpa.entities.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();
    public Product findbyId(Long id);
    public Product save(Product product);
    public Product update(Long id,Product product);
    public Product delete(Long id);
}
