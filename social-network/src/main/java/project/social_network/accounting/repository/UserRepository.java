package project.social_network.accounting.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import project.social_network.accounting.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
