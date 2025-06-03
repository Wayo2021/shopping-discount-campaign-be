package com.example.shopping_campaign_be.service.impl;

import com.example.shopping_campaign_be.entity.Product;
import com.example.shopping_campaign_be.repository.ProductRepository;
import com.example.shopping_campaign_be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProductAll() {

        List<Product> productList = productRepository.findAll();

        return productList;
    }

    @Override
    public Optional<Product> getProductById(String id) {

        Optional<Product> productId = productRepository.findById(id);

        return productId;
    }
}
