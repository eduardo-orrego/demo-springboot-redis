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

    // Endpoint to retrieve a user by ID. Caching applies a default (global) TTL policy.
    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    // Endpoint to retrieve a product by ID. Uses a cache-specific TTL overriding the global cache policy.
    @GetMapping("/products/{productId}")
    public User getProduct(@PathVariable Long productId) {
        return userService.getProductId(productId);
    }
}