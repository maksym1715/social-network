package project.social_network.posts.service;

import java.util.List;

import org.springframework.stereotype.Service;
import project.social_network.posts.Post;
import project.social_network.posts.dto.PostRequest;
import project.social_network.posts.dto.PostResponse;
import project.social_network.posts.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class PostServiceImpl implements PostService{
	
	private final PostRepository postRepository;

	public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostResponse create(PostRequest request) {
        Post post = new Post();
        post.setAuthorId(request.authorId());
        post.setContent(request.content());
        post.setCreatedAt(LocalDateTime.now());
        post.setLikes(List.of());
        postRepository.save(post);
        return toResponse(post);
    }

    @Override
    public List<PostResponse> getAll() {
        return postRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public PostResponse getById(String id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return toResponse(post);
    }

    @Override
    public PostResponse update(String id, PostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        post.setContent(request.content());
        postRepository.save(post);
        return toResponse(post);
    }

    @Override
    public void delete(String id) {
        postRepository.deleteById(id);
    }

    private PostResponse toResponse(Post post) {
        return new PostResponse(post.getId(), post.getContent(), post.getAuthorId(), post.getCreatedAt());
    }

}
