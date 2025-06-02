package com.example.shopping_campaign_be.service;

import com.example.shopping_campaign_be.entity.Cart;
import com.example.shopping_campaign_be.entity.Discount;

import java.util.List;
import java.util.Optional;

public interface DiscountService {

    List<Discount> getDiscountAll();
    Optional<Discount> getDiscountById(String id);

}
