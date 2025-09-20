package project.social_network.surveys.entity;

import jakarta.persistence.*;

@Entity
public class PollQuestion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false) private Poll poll;

    private String keyName;  // например: "empathy", "charisma"
    private String label;    // человекочитаемый заголовок

    @Enumerated(EnumType.STRING)
    private Type type = Type.SLIDER; // SLIDER / TEXT

    // настройки для SLIDER
    private Integer minValue; // напр. 1
    private Integer maxValue; // напр. 10
    private Integer stepValue; // напр. 1

    public enum Type { SLIDER, TEXT }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Poll getPoll() {
		return poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Integer getMinValue() {
		return minValue;
	}

	public void setMinValue(Integer minValue) {
		this.minValue = minValue;
	}

	public Integer getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}

	public Integer getStepValue() {
		return stepValue;
	}

	public void setStepValue(Integer stepValue) {
		this.stepValue = stepValue;
	}

    // getters/setters
}
