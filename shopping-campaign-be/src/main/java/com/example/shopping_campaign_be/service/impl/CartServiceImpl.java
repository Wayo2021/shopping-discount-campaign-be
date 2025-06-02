package com.example.shopping_campaign_be.service.impl;

import com.example.shopping_campaign_be.dto.CartDTO;
import com.example.shopping_campaign_be.entity.Cart;
import com.example.shopping_campaign_be.repository.CartRepository;
import com.example.shopping_campaign_be.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    public Cart initCart(CartDTO cartParam) {
        Cart cartObj = new Cart();

        return cartObj;

    }

    @Override
    public Optional<Cart> saveCart(CartDTO cartParam) {
        return Optional.empty();
    }

    @Override
    public List<Cart> getCartAll() {

        List<Cart> cartList = cartRepository.findAll();

        return cartList;
    }

    @Override
    public Optional<Cart> getCartById(String id) {

        Optional<Cart> cartId = cartRepository.findById(id);

        return cartId;
    }
}
