package project.social_network.surveys.dto;

public record ReportPoint(
	    Long questionId, String keyName, String label, Double average, Long answersCount
	) {}
