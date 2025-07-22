package com.example.rest_jpa.controllers;

import com.example.rest_jpa.entities.Product;
import com.example.rest_jpa.services.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServiceImp service;

    @GetMapping
    @Transactional(readOnly=true)
    public List<Product> findAllProduct(){
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    @Transactional(readOnly=true)
    public Product getByIdProduct(@PathVariable Long id){
        return  this.service.findbyId(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> saveProduct(@RequestBody Product product){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.service.save(product));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Product product){
        Optional<Product> product1=Optional.of(this.service.findbyId(id));

        if(product1.isPresent()){
            Product newProduct=product1.get();
            newProduct.setName(product.getName());
            newProduct.setPrice((product.getPrice()));

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.update(id,newProduct));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public  ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Product> product1=Optional.of(this.service.findbyId(id));

        if(product1.isPresent()){

            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.service.delete(id));
        }

        return ResponseEntity.notFound().build();
    }


}
