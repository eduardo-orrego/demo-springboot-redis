package org.xuaxpedia.redis_data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.xuaxpedia.redis_data.entity.User;

import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // Método para obtener el usuario por ID
    public User getUserById(String id) {
        // Primero intentamos obtener el usuario del caché de Redis
        User user = (User) redisTemplate.opsForValue().get("user:" + id);

        if (user == null) {
            // Si no está en el caché, lo obtenemos de la fuente original (ej., base de datos)
            user = findUserById(id);

            if (user != null) {
                // Guardamos el usuario en Redis con un tiempo de expiración de 10 minutos, por ejemplo
                redisTemplate.opsForValue().set("user:" + id, user, 10, TimeUnit.MINUTES);
            }
        }

        return user;
    }

    // Método simulado que obtiene el usuario de una base de datos o fuente externa
    private User findUserById(String id) {
        // Simular obtener de la base de datos o alguna otra fuente
        return new User(id, "John Doe");
    }
}
