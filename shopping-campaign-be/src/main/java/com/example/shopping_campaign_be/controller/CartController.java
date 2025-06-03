package com.example.shopping_campaign_be.controller;

import com.example.shopping_campaign_be.dto.CartDTO;
import com.example.shopping_campaign_be.entity.Cart;
import com.example.shopping_campaign_be.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/create")
    public ResponseEntity<?> createCart(@RequestBody CartDTO cartParam) {

        Cart cartObj = cartService.initCart(cartParam);

        return ResponseEntity.ok(cartObj);
    }

    @GetMapping("/get")
    public List<Cart> getCartAll() {
        return cartService.getCartAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCartById(@PathVariable String id){
        Optional<Cart> cart = cartService.getCartById(id);

        return ResponseEntity.ok(cart);
    }

    //get, create

    //cart point user
}
