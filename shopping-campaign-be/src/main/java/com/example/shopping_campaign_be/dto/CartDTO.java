package com.example.shopping_campaign_be.dto;

import lombok.Data;

@Data
public class CartDTO {

    private String id;
    private String quantity;
    private String product_id;
    private String discount_id;
    private String user_id;

}
