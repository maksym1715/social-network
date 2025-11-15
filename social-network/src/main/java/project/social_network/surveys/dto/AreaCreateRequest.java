package project.social_network.surveys.dto;


public record AreaCreateRequest(
        Long ownerId,
        String title,
        String description,
        String visibility // "PUBLIC" | "PRIVATE"
) {
}
