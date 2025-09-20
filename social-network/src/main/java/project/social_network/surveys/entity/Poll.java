package project.social_network.surveys.entity;

import jakarta.persistence.*;
import project.social_network.accounting.entity.User;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Poll {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false) private Area area;

    private String title;
    private String description;

    @ManyToOne(optional = false) private User createdBy;

    @Enumerated(EnumType.STRING)
    private Status status = Status.DRAFT; // DRAFT/ACTIVE/CLOSED

    private Instant createdAt = Instant.now();

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PollQuestion> questions = new ArrayList<>();

    public enum Status { DRAFT, ACTIVE, CLOSED }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public List<PollQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<PollQuestion> questions) {
		this.questions = questions;
	}

    // getters/setters
}

