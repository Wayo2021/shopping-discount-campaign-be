package com.example.shopping_campaign_be.service;

import com.example.shopping_campaign_be.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getCategoryAll();
    Optional<Category> getCategoryById(String id);

}
