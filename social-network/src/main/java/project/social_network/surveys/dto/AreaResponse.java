package project.social_network.surveys.dto;

import java.util.List;

public record AreaResponse(
	    Long id, String title, String description, String visibility, Long ownerId, List<Long> memberIds
	) {}
