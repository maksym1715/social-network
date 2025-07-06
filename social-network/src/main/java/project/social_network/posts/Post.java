package project.social_network.posts;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "posts")
public class Post {

    @Id
    private String id;
    private String authorId;
    private String content;
    private LocalDateTime createdAt;
    private List<String> likes;
    

    // Constructors
    public Post() {
    }

    public Post(String authorId, String content, LocalDateTime createdAt, List<String> likes, List<Comment> comments) {
        this.authorId = authorId;
        this.content = content;
        this.createdAt = createdAt;
        this.likes = likes;
        
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

   
}
