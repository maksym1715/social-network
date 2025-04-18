package project.social_network.accounting.service;

import org.springframework.stereotype.Service;
import project.social_network.accounting.dto.UserRequest;
import project.social_network.accounting.dto.UserResponse;
import project.social_network.accounting.entity.User;
import project.social_network.accounting.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
            .stream()
            .map(this::mapToResponse)
            .collect(Collectors.toList());
    }

    public UserResponse registerUser(UserRequest request) {
        User user = new User(
            request.username(),
            request.email(),
            request.password(), 
            request.firstName(),
            request.lastName(),
            request.dateOfBirth(),
            request.gender(),
            request.phoneNumber(),
            request.bio(),
            request.profilePictureUrl()
        );
        User saved = userRepository.save(user);
        return mapToResponse(saved);
    }

    private UserResponse mapToResponse(User user) {
        return new UserResponse(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getFirstName(),
            user.getLastName(),
            user.getDateOfBirth(),
            user.getGender(),
            user.getPhoneNumber(),
            user.getBio(),
            user.getProfilePictureUrl(),
            user.getCreatedAt()
        );
    }
}
