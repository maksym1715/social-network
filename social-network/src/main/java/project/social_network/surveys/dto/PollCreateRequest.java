package project.social_network.surveys.dto;

import java.util.List;

public record PollCreateRequest(
		String title,
	    String description,
	    List<QuestionCreate> questions ) {

}
