package org.cw.midc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.cw.midc.dto.InstanceQueryDto;

public class SeriesQueryDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String seriesUniqueId;
	List<InstanceQueryDto> InstanceQueryDtos = new ArrayList<>();

	public String getSeriesUniqueId() {
		return seriesUniqueId;
	}

	public void setSeriesUniqueId(String seriesUniqueId) {
		this.seriesUniqueId = seriesUniqueId;
	}

	public List<InstanceQueryDto> getInstanceQueryDtos() {
		return InstanceQueryDtos;
	}

	public void setInstanceQueryDtos(List<InstanceQueryDto> instanceQueryDtos) {
		InstanceQueryDtos = instanceQueryDtos;
	}



}