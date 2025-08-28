package project.social_network.surveys.entities;

import jakarta.persistence.*;
import project.social_network.accounting.entity.User;

@Entity
@Table(name = "survey_response",
        uniqueConstraints = @UniqueConstraint(columnNames = {"survey_id", "user_id"}))
public class SurveyResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "survey_id")
    private Survey survey;


    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;


    @Column(nullable = false)
    private int mark;


    @Column(length = 2000)
    private String comment;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
