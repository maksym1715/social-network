package project.social_network.accounting.dto;

public record ProfileRequest(
    String fullName,
    String hobbies,
    String workplace,
    String avatarUrl,
    String privacy
) {}
