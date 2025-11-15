package project.social_network.surveys.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import project.social_network.surveys.dto.SurveyResponseSendDto;
import project.social_network.surveys.entities.SurveyResponse;

import java.time.LocalDateTime;

@Service
public class SenderService {
    private final RestTemplateBuilder restTemplateBuilder;
    private final RestTemplate restTemplate;


    public SenderService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.restTemplate = restTemplateBuilder.build();
    }

    public boolean sendSurvey(SurveyResponse surveyResponse) {
        SurveyResponseSendDto surveyResponseSendDto = new SurveyResponseSendDto(surveyResponse.getId(), surveyResponse.getSurvey().getId(), surveyResponse.getSurvey().getArea().getId(), surveyResponse.getUser().getId(), surveyResponse.getComment(), LocalDateTime.now());
       return false;
    }
}
