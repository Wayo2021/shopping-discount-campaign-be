package com.example.shopping_campaign_be.dto;

import com.example.shopping_campaign_be.model.Discount;
import com.example.shopping_campaign_be.model.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class DiscountDTO {

    private Long id;

    private String name;

    private String discountType;

    private BigDecimal discountValue;

}
