package com.example.shopping_campaign_be.service.impl;

import com.example.shopping_campaign_be.entity.Category;
import com.example.shopping_campaign_be.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> getCategoryAll() {
        return List.of();
    }

    @Override
    public Optional<Category> getCategoryById(String id) {
        return Optional.empty();
    }
}
