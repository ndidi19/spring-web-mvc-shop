package com.ndiaye.m2ishop.repository;

import com.ndiaye.m2ishop.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
