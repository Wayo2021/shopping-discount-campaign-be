package com.example.shopping_campaign_be.service;

import com.example.shopping_campaign_be.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getProductAll();
    Optional<Product> getProductById(String id);
}
