package com.example.shopping_campaign_be.java;

import java.util.HashMap;
import java.util.Map;

public class DatabaseMock {
    public static void main(String[] args) {
        // Category
        Map<Integer, String> category = new HashMap<>();
        category.put(1, "Clothing");
        category.put(2, "Accessories");
        category.put(3, "Electronics");

        // Product
        Map<Integer, Map<String, Object>> product = new HashMap<>();
        product.put(1, Map.of("name", "Hoodie", "price", 700, "category_id", 1));
        product.put(2, Map.of("name", "T-Shirt", "price", 350, "category_id", 1));
        product.put(3, Map.of("name", "Hat", "price", 250, "category_id", 2));
        product.put(4, Map.of("name", "Watch", "price", 850, "category_id", 2));
        product.put(5, Map.of("name", "Bag", "price", 640, "category_id", 2));
        product.put(6, Map.of("name", "Belt", "price", 230, "category_id", 2));
        product.put(7, Map.of("name", "Smartphone", "price", 1000, "category_id", 3));

        // User
        Map<Integer, Map<String, Object>> user = new HashMap<>();
        user.put(1, Map.of("name", "Wayo Wayo", "points", 100));
        user.put(2, Map.of("name", "Somchai Somchai", "points", 150));

        // Discount
        Map<Integer, Map<String, Object>> discount = new HashMap<>();
        discount.put(1, Map.of("name", "Fixed Amount", "discountType", "Coupon Fixed", "discountValue", 50));
        discount.put(2, Map.of("name", "Percentage Discount", "discountType", "Coupon Percentage", "discountValue", 10));
        discount.put(3, Map.of("name", "Percentage discount by item category", "discountType", "Ontop Percentage", "discountValue", 15));
        discount.put(4, Map.of("name", "Discount by points", "discountType", "Ontop Point", "discountValue", 1));
        discount.put(5, Map.of("name", "Special campaigns", "discountType", "Seasonal campaign", "discountValue", 40));

        // Point
        Map<Integer, Map<String, Object>> point = new HashMap<>();
        point.put(1, Map.of("points_spent", 20, "points_balance", 80, "user_id", 1));
        point.put(2, Map.of("points_spent", 30, "points_balance", 120, "user_id", 2));

        // Cart
        Map<Integer, Map<String, Object>> cart = new HashMap<>();
        cart.put(1, Map.of("quantity", 2, "product_id", 1, "discount_id", 1, "user_id", 1));
        cart.put(2, Map.of("quantity", 1, "product_id", 2, "discount_id", 2, "user_id", 2));

        // แสดงผลข้อมูลบางส่วน
        System.out.println("Categories: " + category);
        System.out.println("Products: " + product);
        System.out.println("Users: " + user);
    }
}
