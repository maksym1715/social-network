package project.social_network.accounting.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.social_network.accounting.dto.UserRequest;
import project.social_network.accounting.dto.UserResponse;
import project.social_network.accounting.entity.User;
import project.social_network.accounting.service.LoginService;
import project.social_network.surveys.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final LoginService loginService;
    private final project.social_network.surveys.services.UserService userService;

    // интерфейс
    public UserController(LoginService loginService, UserService userService) {
        this.loginService = loginService;
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return loginService.getAllUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest request) {
        return ResponseEntity.ok(loginService.registerUser(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(loginService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest request) {
        return ResponseEntity.ok(loginService.updateUser(id, request));
    }

    @DeleteMapping("/{id}/{friendId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id, @PathVariable Long friendId) {
        userService.deleteFriend(id, friendId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/friends")
    public ResponseEntity<List<User>> getListOfFriends(@PathVariable long id) {
        List<User> friends = userService.getListOfFriends(id);
        return ResponseEntity.ok(friends);
    }
    @PostMapping("/{id}/friends/{friendId}")
    public ResponseEntity<List<User>> addFriend(
            @PathVariable long id,
            @PathVariable long friendId) {
        List<User> friends = userService.addFriend(id, friendId);
        return ResponseEntity.ok(friends);
    }
}
