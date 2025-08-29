package project.social_network.accounting.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.social_network.accounting.dto.ProfileRequest;
import project.social_network.accounting.dto.ProfileResponse;
import project.social_network.accounting.service.ProfileService;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    // 🔹 POST/PUT: создать или обновить профиль
    @PostMapping("/{userId}")
    public ResponseEntity<ProfileResponse> updateProfile(@PathVariable Long userId,
                                                         @RequestBody ProfileRequest request) {
        return ResponseEntity.ok(profileService.createOrUpdate(userId, request));
    }

    // 🔹 GET: посмотреть чей-то профиль
    @GetMapping("/{userId}")
    public ResponseEntity<ProfileResponse> getProfile(@PathVariable Long userId,
                                                      @RequestParam(required = false) Long viewerId) {
        return ResponseEntity.ok(profileService.getProfile(userId, viewerId));
    }
}

