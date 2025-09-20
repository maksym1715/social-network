package project.social_network.surveys.dto;

import java.util.List;

public record PollReportResponse(
	    Long pollId, String pollTitle, List<ReportPoint> points
	) {}
