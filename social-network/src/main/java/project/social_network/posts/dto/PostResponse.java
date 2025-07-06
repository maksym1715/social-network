package project.social_network.posts.dto;

import java.time.LocalDateTime;

public record PostResponse(
	    String id,
	    String content,
	    String authorId,
	    LocalDateTime createdAt
	) { }
