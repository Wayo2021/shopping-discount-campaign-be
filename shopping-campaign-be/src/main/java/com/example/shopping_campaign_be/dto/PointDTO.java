package com.example.shopping_campaign_be.dto;

import lombok.Data;

@Data
public class PointDTO {

    private Long id;
    private int points_spent;
    private int points_balance;
    private String user_id;

}
