package com.example.shopping_campaign_be.service;

import com.example.shopping_campaign_be.dto.CartDTO;
import com.example.shopping_campaign_be.dto.PointDTO;
import com.example.shopping_campaign_be.entity.Cart;
import com.example.shopping_campaign_be.entity.Point;

import java.util.List;
import java.util.Optional;

public interface PointService {

    Optional<Point> savePoint(PointDTO pointParam);
    List<Point> getPointAll();
    Optional<Point> getPointById(String id);

}
