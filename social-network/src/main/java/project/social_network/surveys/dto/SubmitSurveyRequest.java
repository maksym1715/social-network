package project.social_network.surveys.dto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import project.social_network.surveys.entities.SurveyResponse;

public record SubmitSurveyRequest(Long surveyid, Long userId,int mark, String comment) { }