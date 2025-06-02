package com.example.shopping_campaign_be.service.impl;

import com.example.shopping_campaign_be.dto.PointDTO;
import com.example.shopping_campaign_be.entity.Point;
import com.example.shopping_campaign_be.service.PointService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PointServiceImpl implements PointService {
    @Override
    public Optional<Point> savePoint(PointDTO pointParam) {
        return Optional.empty();
    }

    @Override
    public List<Point> getPointAll() {
        return List.of();
    }

    @Override
    public Optional<Point> getPointById(String id) {
        return Optional.empty();
    }
}
