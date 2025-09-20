package project.social_network.surveys.dto;

public record QuestionCreate(
	    String keyName, String label, String type, Integer minValue, Integer maxValue, Integer stepValue
	) {}
