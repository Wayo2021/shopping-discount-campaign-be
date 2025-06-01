package com.example.shopping_campaign_be.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "discounts")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private DiscountType discountType;

    private BigDecimal discountValue;

    public enum DiscountType {
        COUPON_FIXED,
        COUPON_PERCENTAGE,
        ON_TOP_PERCENTAGE,
        ON_TOP_POINT,
        SEASONAL_CAMPAIGN
    }

}
