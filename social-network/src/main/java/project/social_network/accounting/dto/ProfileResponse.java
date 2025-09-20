package project.social_network.accounting.dto;

public record ProfileResponse(
    Long userId,
    String fullName,
    String hobbies,
    String workplace,
    String avatarUrl,
    String privacy
) {}

