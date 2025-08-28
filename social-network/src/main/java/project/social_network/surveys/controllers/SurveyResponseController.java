package project.social_network.surveys.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.social_network.surveys.entities.SurveyResponse;
import project.social_network.surveys.services.SurveyResponseService;

@RestController
@RequestMapping("/api/survey-responses")
public class SurveyResponseController {
    private final SurveyResponseService surveyResponseService;

    public SurveyResponseController(SurveyResponseService surveyResponseService) {
        this.surveyResponseService = surveyResponseService;
    }


    @PostMapping
    public ResponseEntity<SurveyResponse> submitSurveyResponse(@RequestParam Long surveyId,
                                                               @RequestParam Long userId,
                                                               @RequestParam int mark,
                                                               @RequestParam(required = false) String comment) {
        SurveyResponse response = surveyResponseService.submitSurveyResponse(surveyId, userId, mark, comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
