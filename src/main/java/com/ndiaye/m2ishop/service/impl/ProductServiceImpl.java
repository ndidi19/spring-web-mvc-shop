package com.ndiaye.m2ishop.service.impl;

import com.ndiaye.m2ishop.model.Product;
import com.ndiaye.m2ishop.repository.ProductRepository;
import com.ndiaye.m2ishop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
