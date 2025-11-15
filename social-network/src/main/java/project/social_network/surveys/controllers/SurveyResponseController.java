package project.social_network.surveys.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.social_network.surveys.dto.SubmitSurveyRequest;
import project.social_network.surveys.dto.SurveyResponseCreateResponse;
import project.social_network.surveys.services.SurveyResponseService;

import java.util.List;

@RestController
@RequestMapping("/api/survey-responses")
public class SurveyResponseController {
    private final SurveyResponseService surveyResponseService;

    public SurveyResponseController(SurveyResponseService surveyResponseService) {
        this.surveyResponseService = surveyResponseService;
    }


    @PostMapping
    public ResponseEntity<SurveyResponseCreateResponse> submitSurveyResponse(@RequestBody SubmitSurveyRequest submitSurveyRequest) {
        SurveyResponseCreateResponse response = surveyResponseService.submitSurveyResponse(submitSurveyRequest.surveyid(), submitSurveyRequest.userId(), submitSurveyRequest.mark(),submitSurveyRequest.comment());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("run-job/{id}")
    public List<ResponseEntity<String>> runBatchJob(@PathVariable long id){
        return surveyResponseService.sendAllRequestBuSurveyId(id);
    }
}
