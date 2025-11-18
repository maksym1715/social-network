package project.social_network.surveys.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.boot.spi.InFlightMetadataCollector;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import project.social_network.accounting.entity.User;
import project.social_network.accounting.repository.UserRepository;
import project.social_network.surveys.dto.SurveyResponseCreateResponse;
import project.social_network.surveys.dto.SurveyResponseSendDto;
import project.social_network.surveys.entities.Survey;
import project.social_network.surveys.entities.SurveyResponse;
import project.social_network.surveys.repositories.SurveyRepository;
import project.social_network.surveys.repositories.SurveyResponseRepository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SurveyResponseService {
    private final SurveyResponseRepository responseRepository;
    private final SurveyRepository surveyRepository;
    private final UserRepository userRepository;
    private final RestTemplateBuilder restTemplateBuilder;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)   // force HTTP/1.1
            .build();

    public SurveyResponseService(SurveyResponseRepository responseRepository, SurveyRepository surveyRepository, UserRepository userRepository, RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
        this.responseRepository = responseRepository;
        this.surveyRepository = surveyRepository;
        this.userRepository = userRepository;
        this.restTemplateBuilder = restTemplateBuilder;
        this.restTemplate = restTemplateBuilder.build();
        this.objectMapper = objectMapper;
    }

    public SurveyResponseCreateResponse submitSurveyResponse(Long surveyId, Long userId, int mark, String comment) {
        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(() -> new EntityNotFoundException("Survey not found"));


        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Optional<SurveyResponse> bySurveyIdAndUserId = responseRepository.findBySurveyIdAndUserId(surveyId, userId);
        if (bySurveyIdAndUserId.isPresent()) {
            SurveyResponse surveyResponse = bySurveyIdAndUserId.get();
            surveyResponse.setComment(surveyResponse.getComment() + comment);
            surveyResponse = responseRepository.saveAndFlush(surveyResponse);
            return new SurveyResponseCreateResponse(surveyResponse.getId(), surveyResponse.getSurvey().getArea().getId(), surveyResponse.getSurvey().getId(), surveyResponse.getSurvey().getTitle(), surveyResponse.getSurvey().getArea().getName(), surveyResponse.getMark(), surveyResponse.getComment());
        } else {
            SurveyResponse response = new SurveyResponse();
            response.setSurvey(survey);
            response.setUser(user);
            response.setMark(mark);
            response.setComment(comment);
            response = responseRepository.save(response);
            return new SurveyResponseCreateResponse(response.getId(), response.getSurvey().getArea().getId(), response.getSurvey().getId(), response.getSurvey().getTitle(), response.getSurvey().getArea().getName(), response.getMark(), response.getComment());
        }
    }

    public List<HttpResponse> sendAllRequestBuSurveyId(long surveyId) {
        List<SurveyResponse> allBySurveyId = responseRepository.findAllBySurvey_Id(surveyId);
        return allBySurveyId.stream().map(a -> {
            SurveyResponseSendDto surveyResponseSendDto = new SurveyResponseSendDto(a.getId(), surveyId, a.getSurvey().getArea().getId(), a.getUser().getId(), a.getMark(), a.getComment());
            String json;
            try {
                json = objectMapper.writeValueAsString(surveyResponseSendDto);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8000/api/v1/survey-response"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = null;
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            ResponseEntity<String> response = restTemplate.exchange(
//                    "http://localhost:8000/api/v1/survey-response",
//                    HttpMethod.POST,
//                    entity,
//                    String.class
//            );

            System.out.println("PYTHON RESPONSE: " + response);
            return response;
        }).collect(Collectors.toList());

    }


}
