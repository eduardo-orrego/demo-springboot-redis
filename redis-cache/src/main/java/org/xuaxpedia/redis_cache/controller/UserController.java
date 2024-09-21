package org.xuaxpedia.redis_cache.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.xuaxpedia.redis_cache.entity.User;
import org.xuaxpedia.redis_cache.service.UserService;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint para obtener un usuario por su ID
    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }
}