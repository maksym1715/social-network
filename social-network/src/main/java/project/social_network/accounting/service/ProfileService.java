package project.social_network.accounting.service;

import project.social_network.accounting.dto.ProfileRequest;
import project.social_network.accounting.dto.ProfileResponse;

public interface ProfileService {
    ProfileResponse createOrUpdate(Long userId, ProfileRequest request);
    ProfileResponse getProfile(Long userId, Long viewerId); // viewer — кто смотрит
}

