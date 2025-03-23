package project.social_network.accounting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import project.social_network.accounting.entity.User;
import project.social_network.accounting.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    // Получение списка всех пользователей
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Регистрация нового пользователя
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        // Здесь можно добавить проверку, валидацию и хэширование пароля
        return userRepository.save(user);
    }
}