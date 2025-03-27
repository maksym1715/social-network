package project.social_network.accounting.controller;

import org.springframework.web.bind.annotation.*;
import project.social_network.accounting.dto.UserRequest;
import project.social_network.accounting.dto.UserResponse;
import project.social_network.accounting.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public UserResponse registerUser(@RequestBody UserRequest request) {
        return userService.registerUser(request);
    }
}