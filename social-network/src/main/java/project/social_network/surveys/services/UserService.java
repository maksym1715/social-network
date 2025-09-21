package project.social_network.surveys.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.social_network.accounting.entity.User;
import project.social_network.accounting.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public List<User> getListOfFriends(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user.getFriends();
    }

    public List<User> deleteFriend(long id, long friendId) {
        userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"))
                .getFriends().remove(userRepository.findById(friendId).orElseThrow(() -> new UsernameNotFoundException("Friend not found")));
        return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found")).getFriends();
    }

    public List<User> addFriend(long id, long friendId) {
        userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"))
                .getFriends().add(userRepository.findById(friendId).orElseThrow(() -> new UsernameNotFoundException("Friend not found")));
        return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found")).getFriends();
    }


}
