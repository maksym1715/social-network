package project.social_network.accounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.social_network.accounting.entity.Profile;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUserId(Long userId);
}
