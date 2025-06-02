package com.example.shopping_campaign_be.dto;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class DiscountDTO {

    private String id;

    private String name;

    private String discountType;

    private String discountValue;

}
