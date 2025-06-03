package com.example.shopping_campaign_be.service.impl;

import com.example.shopping_campaign_be.entity.Category;
import com.example.shopping_campaign_be.repository.CategoryRepository;
import com.example.shopping_campaign_be.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategoryAll() {

        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    @Override
    public Optional<Category> getCategoryById(String id) {

        Optional<Category> categoryId = categoryRepository.findById(id);

        return categoryId;
    }
}
