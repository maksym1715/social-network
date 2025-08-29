package project.social_network.surveys.entity;

import jakarta.persistence.*;
import project.social_network.accounting.entity.User;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Area {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Visibility visibility = Visibility.PRIVATE; // PUBLIC/PRIVATE

    @ManyToOne(optional = false)
    private User owner;

    @ManyToMany
    @JoinTable(
        name = "area_members",
        joinColumns = @JoinColumn(name = "area_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> members = new HashSet<>();

    private Instant createdAt = Instant.now();

    public enum Visibility { PUBLIC, PRIVATE }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Set<User> getMembers() {
		return members;
	}

	public void setMembers(Set<User> members) {
		this.members = members;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

    // getters/setters
}
