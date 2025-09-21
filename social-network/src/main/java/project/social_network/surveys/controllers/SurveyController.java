package project.social_network.surveys.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.social_network.surveys.entities.Survey;
import project.social_network.surveys.services.SurveyService;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {
    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }


    @PostMapping
    public ResponseEntity<Survey> addSurveyToArea(@RequestParam Long areaId,
                                                  @RequestParam String title,
                                                  @RequestParam(required = false) String description) {
        Survey createdSurvey = surveyService.addSurveyToArea(areaId, title, description);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSurvey);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Survey> deleteSurvey(@PathVariable Long id) {
        Survey deleted = surveyService.deleteSurvey(id);
        return ResponseEntity.ok(deleted);
    }
}
