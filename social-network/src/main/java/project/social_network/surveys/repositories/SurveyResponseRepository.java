package project.social_network.surveys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.social_network.surveys.entities.SurveyResponse;

import java.util.List;
import java.util.Optional;

public interface SurveyResponseRepository extends JpaRepository<SurveyResponse, Long> {
    Optional<SurveyResponse> findBySurveyIdAndUserId(Long surveyId, Long userId);

    List<SurveyResponse> findAllBySurvey_Id(Long surveyId);
}
