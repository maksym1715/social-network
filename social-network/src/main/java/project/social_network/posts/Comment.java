package project.social_network.posts;

import java.time.LocalDateTime;

public class Comment {

    private String authorId;
    private String content;
    private LocalDateTime createdAt;

    // Constructors
    public Comment() {
    }

    public Comment(String authorId, String content, LocalDateTime createdAt) {
        this.authorId = authorId;
        this.content = content;
        this.createdAt = createdAt;
    }

    // Getters and Setters
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
}