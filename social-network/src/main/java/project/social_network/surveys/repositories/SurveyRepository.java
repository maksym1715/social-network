package project.social_network.surveys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.social_network.surveys.entities.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {}
