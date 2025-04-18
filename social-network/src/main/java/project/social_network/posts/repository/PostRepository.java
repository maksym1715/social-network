package project.social_network.posts.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.social_network.posts.Post;

public interface PostRepository extends MongoRepository<Post, String> {
    
    List<Post> findByAuthorId(String authorId);
}
