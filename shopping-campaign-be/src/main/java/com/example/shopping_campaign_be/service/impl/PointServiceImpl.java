package com.example.shopping_campaign_be.service.impl;

import com.example.shopping_campaign_be.dto.PointDTO;
import com.example.shopping_campaign_be.entity.Point;
import com.example.shopping_campaign_be.repository.PointRepository;
import com.example.shopping_campaign_be.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PointServiceImpl implements PointService {

    @Autowired
    private PointRepository pointRepository;

    @Override
    public Optional<Point> savePoint(PointDTO pointParam) {
        return Optional.empty();
    }

    @Override
    public List<Point> getPointAll() {

        List<Point> pointList = pointRepository.findAll();

        return pointList;
    }

    @Override
    public Optional<Point> getPointById(String id) {

        Optional<Point> pointId = pointRepository.findById(id);

        return pointId;
    }
}
