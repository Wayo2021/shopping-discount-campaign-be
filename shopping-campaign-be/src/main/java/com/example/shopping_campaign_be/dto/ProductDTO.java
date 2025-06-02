package com.example.shopping_campaign_be.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private String id;

    private String name;

    private String price;

    private String category_id;


}
