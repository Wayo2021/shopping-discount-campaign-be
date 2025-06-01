package com.example.shopping_campaign_be.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "points")
public class Point {

    private Long id;
    private int points_spent;
    private int points_balance;
    private String user_id;
}
