package com.example.rest_jpa.repositories;

import com.example.rest_jpa.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
