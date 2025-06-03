package com.example.shopping_campaign_be.service.impl;

import com.example.shopping_campaign_be.entity.Discount;
import com.example.shopping_campaign_be.repository.DiscountRepository;
import com.example.shopping_campaign_be.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public List<Discount> getDiscountAll() {

        List<Discount> discountList = discountRepository.findAll();

        return discountList;
    }

    @Override
    public Optional<Discount> getDiscountById(String id) {

        Optional<Discount> discountId = discountRepository.findById(id);

        return discountId;
    }
}
