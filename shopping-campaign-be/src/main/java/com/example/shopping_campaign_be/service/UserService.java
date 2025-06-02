package com.example.shopping_campaign_be.service;

import com.example.shopping_campaign_be.dto.UserDTO;
import com.example.shopping_campaign_be.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> saveUser(UserDTO userParam);
    List<User> getUserAll();
    Optional<User> getUserById(String id);

}
