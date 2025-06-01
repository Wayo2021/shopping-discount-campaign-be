package com.example.shopping_campaign_be.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private Long id;

    private String name;

    private BigDecimal price;

    private String category_id;


}
