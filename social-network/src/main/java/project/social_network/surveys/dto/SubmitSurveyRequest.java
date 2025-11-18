package project.social_network.surveys.dto;

public record SubmitSurveyRequest(Long surveyId, Long userId, int mark, String comment) { }