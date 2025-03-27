package project.social_network.accounting.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserResponse(
    Long id,
    String username,
    String email,
    String firstName,
    String lastName,
    LocalDate dateOfBirth,
    String gender,
    String phoneNumber,
    String bio,
    String profilePictureUrl,
    LocalDateTime createdAt
) {}
