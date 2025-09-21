package project.social_network.accounting.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import project.social_network.accounting.dto.UserRequest;
import project.social_network.accounting.dto.UserResponse;
import project.social_network.accounting.entity.User;
import project.social_network.accounting.repository.UserRepository;
import project.social_network.accounting.service.LoginService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ── CRUD ──────────────────────────────────────────────────────────────
    @Override
    @Transactional(readOnly = true)
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return mapToResponse(user);
    }

    @Override
    public UserResponse registerUser(UserRequest request) {
        // уникальность email
        userRepository.findByEmail(request.email()).ifPresent(u -> {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already in use");
        });

        User user = new User();
        user.setUsername(request.username() != null && !request.username().isBlank()
                ? request.username()
                : request.email());
        user.setEmail(request.email());

        if (request.password() != null && !request.password().isBlank()) {
            user.setPassword(passwordEncoder.encode(request.password()));
        }

        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setDateOfBirth(request.dateOfBirth());
        user.setGender(request.gender());
        user.setPhoneNumber(request.phoneNumber());
        user.setBio(request.bio());
        user.setProfilePictureUrl(request.profilePictureUrl());

        user.setProvider(null);
        user.setProviderId(null);

        User saved = userRepository.save(user);
        return mapToResponse(saved);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        // email с проверкой уникальности
        if (request.email() != null && !Objects.equals(request.email(), user.getEmail())) {
            userRepository.findByEmail(request.email()).ifPresent(existing -> {
                if (!existing.getId().equals(id)) {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already in use");
                }
            });
            user.setEmail(request.email());
        }

        if (request.username() != null && !request.username().isBlank()) {
            user.setUsername(request.username());
        }
        if (request.password() != null && !request.password().isBlank()) {
            user.setPassword(passwordEncoder.encode(request.password()));
        }

        if (request.firstName() != null) user.setFirstName(request.firstName());
        if (request.lastName() != null) user.setLastName(request.lastName());
        if (request.dateOfBirth() != null) user.setDateOfBirth(request.dateOfBirth());
        if (request.gender() != null) user.setGender(request.gender());
        if (request.phoneNumber() != null) user.setPhoneNumber(request.phoneNumber());
        if (request.bio() != null) user.setBio(request.bio());
        if (request.profilePictureUrl() != null) user.setProfilePictureUrl(request.profilePictureUrl());

        User saved = userRepository.save(user);
        return mapToResponse(saved);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        userRepository.deleteById(id);
    }

    // ── OAuth2 ────────────────────────────────────────────────────────────
    @Override
    public User processOAuthPostLogin(String provider,
                                      String providerId,
                                      String email,
                                      String firstName,
                                      String lastName,
                                      String profilePictureUrl) {

        // 1) пытаемся найти по (provider, providerId)
        Optional<User> byProvider = userRepository.findByProviderAndProviderId(provider, providerId);
        if (byProvider.isPresent()) {
            User u = byProvider.get();
            if (firstName != null) u.setFirstName(firstName);
            if (lastName != null)  u.setLastName(lastName);
            if (profilePictureUrl != null) u.setProfilePictureUrl(profilePictureUrl);
            if (email != null && !Objects.equals(email, u.getEmail())) {
                userRepository.findByEmail(email).ifPresent(existing -> {
                    if (!existing.getId().equals(u.getId())) {
                        throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already in use");
                    }
                });
                u.setEmail(email);
                u.setUsername(email);
            }
            return userRepository.save(u);
        }

        // 2) линковка по email, если уже есть пользователь
        if (email != null) {
            Optional<User> byEmail = userRepository.findByEmail(email);
            if (byEmail.isPresent()) {
                User u = byEmail.get();
                u.setProvider(provider);
                u.setProviderId(providerId);
                if (firstName != null) u.setFirstName(firstName);
                if (lastName != null)  u.setLastName(lastName);
                if (profilePictureUrl != null) u.setProfilePictureUrl(profilePictureUrl);
                return userRepository.save(u);
            }
        }

        // 3) иначе создаём нового
        return registerOAuth2User(email, firstName, lastName, profilePictureUrl, provider, providerId);
    }

    @Override
    public User registerOAuth2User(String email,
                                   String firstName,
                                   String lastName,
                                   String profilePictureUrl,
                                   String provider,
                                   String providerId) {
        User user = new User();
        user.setUsername(email);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setProfilePictureUrl(profilePictureUrl);
        user.setProvider(provider);
        user.setProviderId(providerId);
        // пароль не задаём для social
        return userRepository.save(user);
    }

    // ── Mapper ────────────────────────────────────────────────────────────
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

