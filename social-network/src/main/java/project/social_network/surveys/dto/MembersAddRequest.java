package project.social_network.surveys.dto;

import java.util.List;

public record MembersAddRequest(List<Long> userIds) {}
