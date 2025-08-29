package project.social_network.surveys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.social_network.surveys.entity.Answer;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findByPollQuestionIdIn(List<Long> questionIds);

    @Query("""
        select a.pollQuestion.id, avg(a.valueInt)
        from Answer a
        where a.pollQuestion.id in :questionIds
          and a.valueInt is not null
        group by a.pollQuestion.id
    """)
    List<Object[]> avgByQuestionIds(List<Long> questionIds);
}

