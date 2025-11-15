package project.social_network.surveys.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import project.social_network.accounting.entity.User;
import project.social_network.accounting.repository.UserRepository;
import project.social_network.surveys.dto.SurveyResponseCreateResponse;
import project.social_network.surveys.entities.Survey;
import project.social_network.surveys.entities.SurveyResponse;
import project.social_network.surveys.repositories.SurveyRepository;
import project.social_network.surveys.repositories.SurveyResponseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurveyResponseService {
    private final SurveyResponseRepository responseRepository;
    private final SurveyRepository surveyRepository;
    private final UserRepository userRepository;
    private final RestTemplateBuilder restTemplateBuilder;
    private final RestTemplate restTemplate;

    public SurveyResponseService(SurveyResponseRepository responseRepository, SurveyRepository surveyRepository, UserRepository userRepository, RestTemplateBuilder restTemplateBuilder) {
        this.responseRepository = responseRepository;
        this.surveyRepository = surveyRepository;
        this.userRepository = userRepository;
        this.restTemplateBuilder = restTemplateBuilder;
        this.restTemplate = restTemplateBuilder.build();
    }

    public SurveyResponseCreateResponse submitSurveyResponse(Long surveyId, Long userId, int mark, String comment) {
        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(() -> new EntityNotFoundException("Survey not found"));


        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));


        if (responseRepository.findBySurveyIdAndUserId(surveyId, userId).isPresent()) {
            throw new IllegalStateException("User has already submitted a response to this survey.");
        }
        SurveyResponse response = new SurveyResponse();
        response.setSurvey(survey);
        response.setUser(user);
        response.setMark(mark);
        response.setComment(comment);
        response = responseRepository.save(response);
        return new SurveyResponseCreateResponse(response.getId(), response.getSurvey().getArea().getId(), response.getSurvey().getId(), response.getSurvey().getTitle(), response.getSurvey().getArea().getName(), response.getMark(), response.getComment());
    }

    public List<ResponseEntity<String>> sendAllRequestBuSurveyId(long surveyId) {
        List<SurveyResponse> allBySurveyId = responseRepository.findAllBySurvey_Id(surveyId);
        return allBySurveyId.stream().map(a -> {
            ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:8000", a, String.class);
            System.out.println(stringResponseEntity.toString());
            return stringResponseEntity;
        }).collect(Collectors.toList());

    }


}
