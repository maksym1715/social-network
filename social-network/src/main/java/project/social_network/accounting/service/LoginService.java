package project.social_network.accounting.service;

import project.social_network.accounting.dto.UserRequest;
import project.social_network.accounting.dto.UserResponse;
import project.social_network.accounting.entity.User;

import java.util.List;

public interface LoginService {

    // CRUD
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    UserResponse registerUser(UserRequest request);
    UserResponse updateUser(Long id, UserRequest request);
    void deleteUser(Long id);

    // OAuth2
    User processOAuthPostLogin(String provider,
                               String providerId,
                               String email,
                               String firstName,
                               String lastName,
                               String profilePictureUrl);

    User registerOAuth2User(String email,
                            String firstName,
                            String lastName,
                            String profilePictureUrl,
                            String provider,
                            String providerId);
}

