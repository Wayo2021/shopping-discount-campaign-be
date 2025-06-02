package com.example.shopping_campaign_be.service.impl;

import com.example.shopping_campaign_be.dto.UserDTO;
import com.example.shopping_campaign_be.entity.User;
import com.example.shopping_campaign_be.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Optional<User> saveUser(UserDTO userParam) {
        return Optional.empty();
    }

    @Override
    public List<User> getUserAll() {
        return List.of();
    }

    @Override
    public Optional<User> getUserById(String id) {
        return Optional.empty();
    }
}
