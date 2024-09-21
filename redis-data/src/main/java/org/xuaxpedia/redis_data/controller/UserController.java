package org.xuaxpedia.redis_data.controller;

import org.springframework.web.bind.annotation.RestController;
import org.xuaxpedia.redis_data.entity.User;
import org.xuaxpedia.redis_data.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint para obtener un usuario por su ID
    @GetMapping
    ("/users/{userId}")
    public User getUser(@PathVariable String userId) {
        return userService.getUserById(userId);
    }
}