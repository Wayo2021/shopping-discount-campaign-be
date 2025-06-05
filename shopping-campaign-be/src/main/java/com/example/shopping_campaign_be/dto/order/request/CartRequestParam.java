package com.example.shopping_campaign_be.dto.order.request;

import com.google.gson.JsonElement;

import java.math.BigDecimal;
import java.util.HashMap;

public class CartRequestParam extends HashMap<String, JsonElement> {

    private static final long serialVersionUID = 1L;

    public void putBigDecimal(String price, BigDecimal discountedPrice) {
    }
}
