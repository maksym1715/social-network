package project.social_network.surveys.dto;

import java.time.LocalDateTime;

public class SurveyResponseSendDto {
    long id;

    public long getId() {
        return id;
    }

    public long getSurveyId() {
        return surveyId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSurveyId(long surveyId) {
        this.surveyId = surveyId;
    }

    public void setAreaId(long areaId) {
        this.areaId = areaId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setMark(long mark) {
        this.mark = mark;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getAreaId() {
        return areaId;
    }

    public long getUserId() {
        return userId;
    }

    public long getMark() {
        return mark;
    }

    public String getComment() {
        return comment;
    }

    long surveyId;

    long areaId;

    long userId;
    long mark;
    String comment;

    public SurveyResponseSendDto() {}
    public SurveyResponseSendDto(long id, long surveyId, long areaId, long userId, long mark, String comment) {
        this.id = id;
        this.surveyId = surveyId;
        this.areaId = areaId;
        this.userId = userId;
        this.mark = mark;
        this.comment = comment;
    }
}




//{
//        "chunkId": "uuid"
//        "responseId": "resp_987",
//        "surveyId": "s55",
//        "areaId": "vasya_poetry",
//        "subjectUserId": "u123",       // the person or thing being reviewed
//        "authorUserId": "u777",        // who wrote the response
//        "language": "en",
//        "createdAt": "2025-10-25T09:00:00Z",
//        "source": "surveyResponse"
//        }
