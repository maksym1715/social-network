package project.social_network.surveys.dto;

public record SurveyResponseCreateResponse(long id,
                                           long areaId,
                                           long surveyId,
                                           String surveyTitle,
                                           String areaName,
                                           int mark,
                                           String comment) {
}
