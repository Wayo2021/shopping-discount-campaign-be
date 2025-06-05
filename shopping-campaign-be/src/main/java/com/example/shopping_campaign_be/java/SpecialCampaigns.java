package com.example.shopping_campaign_be.java;

import com.example.shopping_campaign_be.java.discount.DiscountCalculator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
public class SpecialCampaigns {
    public static void main(String[] args) {

        // ข้อมูลส่วนลด
        Map<String, Map<String, Object>> discountData = new HashMap<>();
        discountData.put("Special campaigns", Map.of("discountType", "SEASONAL_CAMPAIGN_T", "discountValue", new BigDecimal(40)));

        // ข้อมูลสินค้า
        Map<String, Map<String, Object>> productData = new HashMap<>();
        productData.put("T-Shirt", Map.of("price", new BigDecimal(350), "category", "Clothing"));
        productData.put("Hat", Map.of("price", new BigDecimal(250), "category", "Accessories"));
        productData.put("Belt", Map.of("price", new BigDecimal(230), "category", "Clothing"));

        BigDecimal discountedPrice = BigDecimal.ZERO;
        discountedPrice = DiscountCalculator.discountCampaign(discountData,productData);

        System.out.println("ราคาหลังหักส่วนลด: " + discountedPrice);
    }
}
