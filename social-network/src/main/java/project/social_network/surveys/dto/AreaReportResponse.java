package project.social_network.surveys.dto;

import java.util.List;

public record AreaReportResponse(
	    Long areaId, String areaTitle, List<ReportPoint> points
	) {}
