package com.example.shopping_campaign_be.java;
import com.example.shopping_campaign_be.java.discount.DiscountCalculator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PercentageDiscountByItemCategory {
    public static void main(String[] args) {

        // ข้อมูลส่วนลด
        Map<String, Map<String, Object>> discountData = new HashMap<>();
        discountData.put("Percentage discount by item category", Map.of("discountType", "ON_TOP_PERCENTAGE_T", "discountValue", new BigDecimal(15)));

        // ข้อมูลสินค้า
        Map<String, Map<String, Object>> productData = new HashMap<>();
        productData.put("Hoodie", Map.of("price", new BigDecimal(700), "category", "Clothing"));
        productData.put("T-Shirt", Map.of("price", new BigDecimal(350), "category", "Clothing"));
        productData.put("Watch", Map.of("price", new BigDecimal(850), "category", "Accessories"));
        productData.put("Bag", Map.of("price", new BigDecimal(640), "category", "Accessories"));

        BigDecimal discountedPrice = BigDecimal.ZERO;
        discountedPrice = DiscountCalculator.discountCampaign(discountData,productData);

        System.out.println("ราคาหลังหักส่วนลด: " + discountedPrice);
    }
}
