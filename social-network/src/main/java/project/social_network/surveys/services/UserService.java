package project.social_network.surveys.services;

//import org.springframework.security.core.userdetails.Exception;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import project.social_network.accounting.dto.UserRequest;
import project.social_network.accounting.dto.UserResponse;
import project.social_network.accounting.entity.User;
import project.social_network.accounting.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public UserResponse getUserById(long id) throws Exception {
        User save = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return new UserResponse(save.getId(), save.getUsername(), save.getUsername(), save.getFirstName(), save.getLastName(), save.getDateOfBirth(), save.getGender(), save.getPhoneNumber(), save.getBio(), save.getProfilePictureUrl(), save.getCreatedAt());

    }

    public List<User> getListOfFriends(long id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return user.getFriends();
    }

    public List<User> deleteFriend(long id, long friendId) throws Exception {
        userRepository.findById(id).orElseThrow(() -> new Exception("User not found"))
                .getFriends().remove(userRepository.findById(friendId).orElseThrow(() -> new EntityNotFoundException("Friend not found")));
        return userRepository.findById(id).orElseThrow(() -> new Exception("User not found")).getFriends();
    }

    public List<User> addFriend(long id, long friendId) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
        user.getFriends().add(userRepository.findById(friendId).orElseThrow(() -> new EntityNotFoundException("Friend not found")));
        return userRepository.save(user).getFriends();
    }

    public UserResponse registerUser(UserRequest userRequest) {
        User save = userRepository.save(new User(userRequest.username(), userRequest.email(), userRequest.password(), userRequest.firstName(), userRequest.lastName(), userRequest.dateOfBirth(), userRequest.gender(), userRequest.phoneNumber(), userRequest.bio(), userRequest.profilePictureUrl()));
        return new UserResponse(save.getId(), save.getUsername(), save.getUsername(), save.getFirstName(), save.getLastName(), save.getDateOfBirth(), save.getGender(), save.getPhoneNumber(), save.getBio(), save.getProfilePictureUrl(), save.getCreatedAt());
    }

    public List<UserResponse> getListOfUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(save -> {
            return new UserResponse(save.getId(), save.getUsername(), save.getUsername(), save.getFirstName(), save.getLastName(), save.getDateOfBirth(), save.getGender(), save.getPhoneNumber(), save.getBio(), save.getProfilePictureUrl(), save.getCreatedAt());
        }).toList();
    }

}
