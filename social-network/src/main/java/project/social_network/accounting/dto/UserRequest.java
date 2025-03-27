package project.social_network.accounting.dto;

import java.time.LocalDate;

public record UserRequest(
    String username,
    String email,
    String password,
    String firstName,
    String lastName,
    LocalDate dateOfBirth,
    String gender,
    String phoneNumber,
    String bio,
    String profilePictureUrl
) {}
