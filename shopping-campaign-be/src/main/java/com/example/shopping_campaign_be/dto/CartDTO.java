package com.example.shopping_campaign_be.dto;

import lombok.Data;

@Data
public class CartDTO {

    private Long id;
    private String quantity;
    private String item_id;
    private String discount_id;

}
