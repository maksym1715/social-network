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

    private final project.social_network.surveys.services.UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getListOfUsers() {
        return userService.getListOfUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.registerUser(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(userService.getUserById(id));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest request) {
//        return ResponseEntity.ok(loginService.updateUser(id, request));
//    }

    @DeleteMapping("/{id}/{friendId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id, @PathVariable Long friendId) throws Exception {
        userService.deleteFriend(id, friendId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/friends")
    public ResponseEntity<List<User>> getListOfFriends(@PathVariable long id) throws Exception {
        List<User> friends = userService.getListOfFriends(id);
        return ResponseEntity.ok(friends);
    }
    @PostMapping("/{id}/friends/{friendId}")
    public ResponseEntity<List<User>> addFriend(
            @PathVariable long id,
            @PathVariable long friendId) throws Exception {
        List<User> friends = userService.addFriend(id, friendId);
        return ResponseEntity.ok(friends);
    }
}
