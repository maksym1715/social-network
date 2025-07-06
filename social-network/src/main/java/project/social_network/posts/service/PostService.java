package project.social_network.posts.service;

import java.util.List;

import project.social_network.posts.dto.PostRequest;
import project.social_network.posts.dto.PostResponse;

public interface PostService {
	PostResponse create(PostRequest request);
    List<PostResponse> getAll();
    PostResponse getById(String id);
    PostResponse update(String id, PostRequest request);
    void delete(String id);
}
