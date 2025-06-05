package com.example.shopping_campaign_be.java;

import com.example.shopping_campaign_be.java.discount.DiscountCalculator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PercentageDiscount {
    public static void main(String[] args) {
        // ข้อมูลส่วนลด
        Map<String, Map<String, Object>> discountData = new HashMap<>();
        discountData.put("Percentage Discount", Map.of("discountType", "COUPON_PERCENTAGE_T", "discountValue", new BigDecimal(10)));

        // ข้อมูลสินค้า
        Map<String, Map<String, Object>> productData = new HashMap<>();
        productData.put("T-Shirt", Map.of("price", new BigDecimal(350), "category", "Clothing"));
        productData.put("Hat", Map.of("price", new BigDecimal(250), "category", "Accessories"));

        BigDecimal discountedPrice = BigDecimal.ZERO;
        discountedPrice = DiscountCalculator.discountCampaign(discountData,productData);

        System.out.println("ราคาหลังหักส่วนลด: " + discountedPrice);
    }
}
