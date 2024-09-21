package org.xuaxpedia.redis_cache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.xuaxpedia.redis_cache.entity.User;

@Service
public class UserService {

    // Simula la búsqueda de un usuario por su ID (normalmente esto vendría de una base de datos)
    @Cacheable(value = "users", key = "#userId")
    public User getUserById(Long userId) {
        simulateSlowService(); // Simula un proceso lento, por ejemplo, una consulta a la base de datos
        return new User(userId, "User" + userId);
    }

    // Método para simular un retraso
    private void simulateSlowService() {
        try {
            Thread.sleep(3000);  // Simula una demora de 3 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

