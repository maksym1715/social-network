package project.social_network.accounting.service.impl;

import org.springframework.stereotype.Service;
import project.social_network.accounting.dto.ProfileRequest;
import project.social_network.accounting.dto.ProfileResponse;
import project.social_network.accounting.entity.Profile;
import project.social_network.accounting.entity.User;
import project.social_network.accounting.repository.ProfileRepository;
import project.social_network.accounting.repository.UserRepository;
import project.social_network.accounting.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepo;
    private final UserRepository userRepo;

    public ProfileServiceImpl(ProfileRepository profileRepo, UserRepository userRepo) {
        this.profileRepo = profileRepo;
        this.userRepo = userRepo;
    }

    @Override
    public ProfileResponse createOrUpdate(Long userId, ProfileRequest req) {
        User user = userRepo.findById(userId).orElseThrow();
        Profile profile = profileRepo.findByUserId(userId).orElse(new Profile());
        profile.setUser(user);
        profile.setFullName(req.fullName());
        profile.setHobbies(req.hobbies());
        profile.setWorkplace(req.workplace());
        profile.setAvatarUrl(req.avatarUrl());
        profile.setPrivacy(req.privacy());

        profileRepo.save(profile);

        return toResponse(profile);
    }

    @Override
    public ProfileResponse getProfile(Long userId, Long viewerId) {
        Profile profile = profileRepo.findByUserId(userId)
            .orElseThrow(() -> new RuntimeException("Profile not found"));

        if (!profile.getPrivacy().equalsIgnoreCase("public") && !userId.equals(viewerId)) {
            throw new RuntimeException("Private Profile");
        }

        return toResponse(profile);
    }

    private ProfileResponse toResponse(Profile p) {
        return new ProfileResponse(
            p.getUser().getId(),
            p.getFullName(),
            p.getHobbies(),
            p.getWorkplace(),
            p.getAvatarUrl(),
            p.getPrivacy()
        );
    }
}

