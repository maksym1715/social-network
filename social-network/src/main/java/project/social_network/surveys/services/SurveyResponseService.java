package project.social_network.surveys.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import project.social_network.accounting.entity.User;
import project.social_network.accounting.repository.UserRepository;
import project.social_network.surveys.entities.Survey;
import project.social_network.surveys.entities.SurveyResponse;
import project.social_network.surveys.repositories.SurveyRepository;
import project.social_network.surveys.repositories.SurveyResponseRepository;

@Service
public class SurveyResponseService {
    private final SurveyResponseRepository responseRepository;
    private final SurveyRepository surveyRepository;
    private final UserRepository userRepository;

    public SurveyResponseService(SurveyResponseRepository responseRepository, SurveyRepository surveyRepository, UserRepository userRepository) {
        this.responseRepository = responseRepository;
        this.surveyRepository = surveyRepository;
        this.userRepository = userRepository;
    }

    public SurveyResponse submitSurveyResponse(Long surveyId, Long userId, int mark, String comment) {
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
        return responseRepository.save(response);
    }
}
