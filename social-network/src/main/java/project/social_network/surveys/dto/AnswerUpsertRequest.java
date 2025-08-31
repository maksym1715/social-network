package project.social_network.surveys.dto;

public record AnswerUpsertRequest(
	    Long questionId,
	    Integer valueInt,
	    String valueText
	) {}
