package com.example.shopping_campaign_be.repository;

import com.example.shopping_campaign_be.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<Point, String> {
}
