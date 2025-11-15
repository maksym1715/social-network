package project.social_network.surveys.dto;

import java.time.LocalDateTime;

public record SurveyResponseSendDto(long id,
                                    long surveyId,
                                    long areaId,
                                    long userId,
                                    String message,
                                    LocalDateTime localDateTime) {
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
