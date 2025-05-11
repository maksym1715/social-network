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

    // Standard registration via form (username, password и etc.)
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
            request.profilePictureUrl(),
            null, // provider 
            null  // providerId 
        );
        User saved = userRepository.save(user);
        return mapToResponse(saved);
    }

    // OAuth2-
    public User registerOAuth2User(String email, String firstName, String lastName, String profilePictureUrl, String provider, String providerId) {
        User user = new User(
        		email,                  // Use email as username  
        		email,                  // Email address  
        		firstName,              // First name  
        		lastName,               // Last name  
        		profilePictureUrl,      // Profile picture URL  
        		provider,               // OAuth2 provider (e.g., Google, Facebook, etc.)  
        		providerId              // Unique ID of the user from the provider 
        );
        return userRepository.save(user);
    }

    // Handling OAuth2 login (create new user or fetch existing one)
    public User processOAuthPostLogin(String provider, String providerId, String email, String firstName, String lastName, String profilePictureUrl) {
        return userRepository.findByProviderAndProviderId(provider, providerId)
            .orElseGet(() -> registerOAuth2User(email, firstName, lastName, profilePictureUrl, provider, providerId));
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
