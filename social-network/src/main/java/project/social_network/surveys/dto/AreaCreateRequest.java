package project.social_network.surveys.dto;


public record AreaCreateRequest(
    String title,
    String description,
    String visibility // "PUBLIC" | "PRIVATE"
) {}
