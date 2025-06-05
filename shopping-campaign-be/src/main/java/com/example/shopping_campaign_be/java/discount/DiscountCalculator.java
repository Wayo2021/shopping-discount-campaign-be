package com.example.shopping_campaign_be.java.discount;

import java.math.BigDecimal;
import java.util.Map;

public class DiscountCalculator {


//    public static void main(String[] args) {
//        // ข้อมูลส่วนลด
//        Map<String, Map<String, Object>> discountData = new HashMap<>();
//        discountData.put("Fixed Amount", Map.of("discountType", "COUPON_FIXED_T", "discountValue", new BigDecimal(50)));
//        discountData.put("Percentage Discount", Map.of("discountType", "COUPON_PERCENTAGE_T", "discountValue", new BigDecimal(10)));
//        discountData.put("Percentage discount by item category", Map.of("discountType", "ON_TOP_PERCENTAGE_T", "discountValue", new BigDecimal(15)));
//        discountData.put("Discount by points", Map.of("discountType", "ON_TOP_POINT_T", "discountValue", new BigDecimal(1)));
//        discountData.put("Special campaigns", Map.of("discountType", "SEASONAL_CAMPAIGN_T", "discountValue", new BigDecimal(40)));
//
//        // ข้อมูลสินค้า
//        Map<String, Map<String, Object>> productData = new HashMap<>();
//        productData.put("Hoodie", Map.of("price", new BigDecimal(700), "category", "Clothing"));
//        productData.put("T-Shirt", Map.of("price", new BigDecimal(350), "category", "Clothing"));
//        productData.put("Hat", Map.of("price", new BigDecimal(250), "category", "Accessories"));
//        productData.put("Watch", Map.of("price", new BigDecimal(850), "category", "Accessories"));
//        productData.put("Bag", Map.of("price", new BigDecimal(640), "category", "Accessories"));
//        productData.put("Belt", Map.of("price", new BigDecimal(230), "category", "Clothing"));
//        productData.put("Smartphone", Map.of("price", new BigDecimal(1000), "category", "Electronics"));
//
//
//
//    }

    public static BigDecimal discountCampaign(Map<String, Map<String, Object>> discountData,Map<String, Map<String, Object>> productData) {

        // ส่วนลดที่จะใช้
        BigDecimal total = BigDecimal.ZERO;
        for (Map<String, Object> productObj : productData.values()) {
            total = total.add((BigDecimal) productObj.get("price"));
        }

        String discountTypeMap = "";
        BigDecimal discountValueMap = BigDecimal.ZERO;
        for (Map<String, Object> discountObj : discountData.values()) {
            discountTypeMap = discountObj.get("discountType").toString();
            discountValueMap = new BigDecimal(discountObj.get("discountValue").toString());
        }

        BigDecimal discountedPrice = total;
        String discountType = "";
        BigDecimal discountValue = null;

        discountType = discountTypeMap;
        discountValue = discountValueMap;

        // คำนวณส่วนลด
        if (discountType.equals("COUPON_FIXED_T")) {

            discountedPrice = discountedPrice.subtract(discountValue);

        } else if (discountType.equals("COUPON_PERCENTAGE_T")) {

            BigDecimal discountAmount = discountedPrice.multiply(discountValue.divide(new BigDecimal(100)));
            discountedPrice = discountedPrice.subtract(discountAmount);

        } else if (discountType.equals("ON_TOP_PERCENTAGE_T")) {

            BigDecimal totalClothingPrice = BigDecimal.ZERO;

            for (Map.Entry<String, Map<String, Object>> entry : productData.entrySet()) {
                Map<String, Object> productObj = entry.getValue();
                BigDecimal price = (BigDecimal) productObj.get("price");
                if (productObj.get("category").equals("Clothing")) {
                    totalClothingPrice = totalClothingPrice.add(price);
                }
            }

            BigDecimal discountAmount = totalClothingPrice.multiply(discountValue.divide(new BigDecimal(100)));
            discountedPrice = discountedPrice.subtract(discountAmount);

        } else if (discountType.equals("ON_TOP_POINT_T")) {

            discountedPrice = discountedPrice.subtract(discountValue);

        } else if (discountType.equals("SEASONAL_CAMPAIGN_T")) {

            BigDecimal totalPrice = BigDecimal.ZERO;

            // รวมราคาสินค้าทั้งหมด
            for (Map<String, Object> productObj : productData.values()) {
                BigDecimal price = (BigDecimal) productObj.get("price");
                totalPrice = totalPrice.add(price);
            }

            // คำนวณส่วนลดทุก ๆ 300 บาท ลด 40 บาท
            BigDecimal unitThreshold = new BigDecimal("300");
            BigDecimal discountMultiplier = totalPrice.divide(unitThreshold, 0, BigDecimal.ROUND_DOWN);
            BigDecimal totalDiscount = discountMultiplier.multiply(discountValue);

            discountedPrice = totalPrice.subtract(totalDiscount);

        }

        return discountedPrice;

    }

}
