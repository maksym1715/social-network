package project.social_network.surveys.dto;

public record PollResponse(
	    Long id, Long areaId, String title, String description, String status
	) {}
