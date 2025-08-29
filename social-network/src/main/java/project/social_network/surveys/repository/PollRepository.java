package project.social_network.surveys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.social_network.surveys.entity.Poll;

import java.util.List;

public interface PollRepository extends JpaRepository<Poll, Long> {
    List<Poll> findByAreaId(Long areaId);
}

