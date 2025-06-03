package com.example.shopping_campaign_be.service.impl;

import com.example.shopping_campaign_be.dto.UserDTO;
import com.example.shopping_campaign_be.entity.User;
import com.example.shopping_campaign_be.repository.UserRepository;
import com.example.shopping_campaign_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> saveUser(UserDTO userParam) {
        return Optional.empty();
    }

    @Override
    public List<User> getUserAll() {

        List<User> userList = userRepository.findAll();

        return userList;
    }

    @Override
    public Optional<User> getUserById(String id) {

        Optional<User> userId = userRepository.findById(id);

        return userId;
    }
}
