package org.cw.midc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudyQueryDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String studyUniqueId;
	
	private List<SeriesQueryDto> SeriesQueryDtos = new ArrayList<>();
	
	public String getStudyUniqueId() {
		return studyUniqueId;
	}

	public void setStudyUniqueId(String studyUniqueId) {
		this.studyUniqueId = studyUniqueId;
	}

	public List<SeriesQueryDto> getSeriesQueryDtos() {
		return SeriesQueryDtos;
	}

	public void setSeriesQueryDtos(List<SeriesQueryDto> seriesQueryDtos) {
		SeriesQueryDtos = seriesQueryDtos;
	}
	
	

}
