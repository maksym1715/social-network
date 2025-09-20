package project.social_network.surveys.entity;

import jakarta.persistence.*;
import project.social_network.accounting.entity.User;
import java.time.Instant;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"poll_question_id", "respondent_id"})
})
public class Answer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false) private PollQuestion pollQuestion;
    @ManyToOne(optional = false) private User respondent;

    // Для SLIDER
    private Integer valueInt;

    // Для TEXT (включая speech2text — просто текст)
    @Column(length = 4000)
    private String valueText;

    private Instant createdAt = Instant.now();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PollQuestion getPollQuestion() {
		return pollQuestion;
	}

	public void setPollQuestion(PollQuestion pollQuestion) {
		this.pollQuestion = pollQuestion;
	}

	public User getRespondent() {
		return respondent;
	}

	public void setRespondent(User respondent) {
		this.respondent = respondent;
	}

	public Integer getValueInt() {
		return valueInt;
	}

	public void setValueInt(Integer valueInt) {
		this.valueInt = valueInt;
	}

	public String getValueText() {
		return valueText;
	}

	public void setValueText(String valueText) {
		this.valueText = valueText;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

    // getters/setters
}
 
