package com.example.shopping_campaign_be.service.impl;

import com.example.shopping_campaign_be.entity.Discount;
import com.example.shopping_campaign_be.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Override
    public List<Discount> getDiscountAll() {
        return List.of();
    }

    @Override
    public Optional<Discount> getDiscountById(String id) {
        return Optional.empty();
    }
}
