package com.example.rest_jpa.services;

import com.example.rest_jpa.entities.Product;
import com.example.rest_jpa.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) this.repository.findAll();
    }

    @Override
    public Product findbyId(Long id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return this.repository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Product prod=this.repository.findById(id).get();

        prod.setName(product.getName());
        prod.setPrice(product.getPrice());

        return this.repository.save(prod);
    }

    @Override
    public Product delete(Long id) {
        Product prod=this.repository.findById(id).get();

        this.repository.deleteById(id);

        return prod;
    }
}
