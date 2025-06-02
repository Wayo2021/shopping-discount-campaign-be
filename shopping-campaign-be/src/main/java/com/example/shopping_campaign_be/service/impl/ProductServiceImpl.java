package com.example.shopping_campaign_be.service.impl;

import com.example.shopping_campaign_be.entity.Product;
import com.example.shopping_campaign_be.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getProductAll() {
        return List.of();
    }

    @Override
    public Optional<Product> getProductById(String id) {
        return Optional.empty();
    }
}
