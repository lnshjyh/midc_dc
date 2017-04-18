package org.cw.midc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.cw.midc.dto.InstanceQueryDto;
import org.cw.midc.dto.SeriesQueryDto;
import org.cw.midc.dto.StudyQueryDto;
import org.cw.midc.model.pacs.Instance;
import org.cw.midc.model.pacs.Series;
import org.cw.midc.model.pacs.Study;
import org.cw.midc.model.ris.StudyInfo;
import org.cw.midc.repository.pacs.InstanceRepository;
import org.cw.midc.repository.pacs.SeriesRepository;
import org.cw.midc.repository.pacs.StudyRepository;
import org.cw.midc.repository.ris.StudyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudyService {
	
	@Autowired
	private StudyInfoRepository studyInfoRepository;
	
	@Autowired
	private StudyRepository studyRepository;
	
	@Autowired
	private SeriesRepository seriesRepository;
	
	@Autowired
	private InstanceRepository instanceRepository;
	
	public List<StudyQueryDto> getStudyStruct(String studyInfoId)
	{
		StudyInfo studyInfo = studyInfoRepository.findOne(studyInfoId);
		if(studyInfo == null)
		{
			return null;
		}
		Set<Study> studys = studyInfo.getStudies();
		if(studys == null || studys.isEmpty())
		{
			return null;
		}
		List<StudyQueryDto> studyQueryDtos = new ArrayList<>();
		studys.forEach(study -> {
			StudyQueryDto studyQueryDto = new StudyQueryDto(); 
			studyQueryDto.setStudyUniqueId(study.getStudyUniqueId());			
			List<Series> series = seriesRepository.findByStudyUniqueId(study.getStudyUniqueId());
			series.forEach(seriesSingle -> {
				SeriesQueryDto seriesQueryDto = new SeriesQueryDto();
				seriesQueryDto.setSeriesUniqueId(seriesSingle.getSeriesUniqueId());				
				List<Instance> instances = instanceRepository.findBySeriesUniqueId(seriesSingle.getSeriesUniqueId());
				instances.forEach(instance -> {
					InstanceQueryDto instanceQueryDto = new InstanceQueryDto();
					instanceQueryDto.setInstanceUniqueId(instance.getInstanceUId());
					instanceQueryDto.setFileId(instance.getFileId());
					seriesQueryDto.getInstanceQueryDtos().add(instanceQueryDto);
				});
				studyQueryDto.getSeriesQueryDtos().add(seriesQueryDto);
			});
			studyQueryDtos.add(studyQueryDto);
		});
		
		return studyQueryDtos;
	}

}
