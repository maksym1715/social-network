package project.social_network.posts.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.social_network.posts.Comment;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByPostId(String postId);
}
