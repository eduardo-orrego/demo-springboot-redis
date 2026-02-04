package org.xuaxpedia.redis_cache.service;

import java.time.Duration;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.xuaxpedia.redis_cache.entity.User;

@Service
public class UserService {

    //Simulates searching for a user by their ID (normally this would come from a database)
    @Cacheable(
      cacheNames = "users",
      key = "#userId",
      unless = "#result == null" //Avoid caching null values
    )    public User getUserById(Long userId) {
        simulateSlowService(); // It simulates a slow process, for example, a database query.
        return new User(userId, "User" + userId);
    }

    //Simulates searching for a product by their ID (normally this would come from a database)
    @Cacheable(
      cacheNames = "products",
      key = "#productId",
      unless = "#result == null"
    )    public User getProductId(Long productId) {
        simulateSlowService();
        return new User(productId, "Product" + productId);
    }

    //Simulates a slow downstream call (e.g. database or external service) for demo purposes.
    private void simulateSlowService() {
        try {
            Thread.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

