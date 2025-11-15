package project.social_network.surveys.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import project.social_network.surveys.dto.SurveyCreateResponse;
import project.social_network.surveys.entities.Area;
import project.social_network.surveys.entities.Survey;
import project.social_network.surveys.repositories.AreaRepository;
import project.social_network.surveys.repositories.SurveyRepository;

@Service
public class SurveyService {

    private final SurveyRepository surveyRepository;
    private final AreaRepository areaRepository;

    public SurveyService(SurveyRepository surveyRepository, AreaRepository areaRepository) {
        this.surveyRepository = surveyRepository;
        this.areaRepository = areaRepository;
    }
    public SurveyCreateResponse addSurveyToArea(Long areaId, String title, String description) {
        Area area = areaRepository.findById(areaId)
                .orElseThrow(() -> new EntityNotFoundException("Area not found"));


        Survey survey = new Survey();
        survey.setArea(area);
        survey.setTitle(title);
        survey.setDescription(description);
        Survey savedSurveys = surveyRepository.save(survey);
        return new SurveyCreateResponse(savedSurveys.getId(), area.getName(), survey.getId(), survey.getTitle(), survey.getTitle());
    }
    public Survey deleteSurvey(Long id) {
        Survey survey = surveyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Survey not found"));
        surveyRepository.delete(survey);
        return survey;
    }
}
