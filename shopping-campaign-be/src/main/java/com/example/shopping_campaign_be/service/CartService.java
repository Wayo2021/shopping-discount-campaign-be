package com.example.shopping_campaign_be.service;

import com.example.shopping_campaign_be.dto.CartDTO;
import com.example.shopping_campaign_be.dto.order.request.CartRequestParam;
import com.example.shopping_campaign_be.dto.order.request.RequestParam;
import com.example.shopping_campaign_be.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {

    Optional<Cart> saveCart(CartDTO cartParam);
    List<Cart> getCartAll();
    Optional<Cart> getCartById(String id);
    Cart initCart(RequestParam param);
    CartRequestParam cartCalculate(RequestParam param);
}
