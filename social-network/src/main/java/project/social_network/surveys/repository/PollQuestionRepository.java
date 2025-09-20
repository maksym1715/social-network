package project.social_network.surveys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.social_network.surveys.entity.PollQuestion;

import java.util.List;

public interface PollQuestionRepository extends JpaRepository<PollQuestion, Long> {
    List<PollQuestion> findByPollId(Long pollId);
}


