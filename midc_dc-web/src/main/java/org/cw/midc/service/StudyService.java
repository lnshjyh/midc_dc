package org.cw.midc.service;

import java.util.ArrayList;
import java.util.List;

import org.cw.midc.dao.InstanceDao;
import org.cw.midc.dao.SeriesDao;
import org.cw.midc.dao.StudyDao;
import org.cw.midc.dto.InstanceQueryDto;
import org.cw.midc.dto.SeriesQueryDto;
import org.cw.midc.dto.StudyQueryDto;
import org.cw.midc.entity.Instance;
import org.cw.midc.entity.Series;
import org.cw.midc.entity.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudyService {
	
	@Autowired
	private StudyDao studyDao;
	
	@Autowired
	private SeriesDao seriesDao;
	
	@Autowired
	private InstanceDao instanceDao;
	
	public List<StudyQueryDto> getStudyStruct(String studyInfoId)
	{
		List<Study> studys = studyDao.find("selectByStudyInfoId", studyInfoId);
		if(studys == null || studys.isEmpty())
		{
			return null;
		}
		List<StudyQueryDto> studyQueryDtos = new ArrayList<>();
		studys.forEach(study -> {
			StudyQueryDto studyQueryDto = new StudyQueryDto(); 
			studyQueryDto.setStudyUniqueId(study.getStudyUid());			
			List<Series> series = seriesDao.find("selectByStudyUId", study.getStudyUid());
			series.forEach(seriesSingle -> {
				SeriesQueryDto seriesQueryDto = new SeriesQueryDto();
				seriesQueryDto.setSeriesUniqueId(seriesSingle.getSeriesUid());				
				List<Instance> instances = instanceDao.find("selectBySeriesUId", seriesSingle.getSeriesUid());
				instances.forEach(instance -> {
					InstanceQueryDto instanceQueryDto = new InstanceQueryDto();
					instanceQueryDto.setInstanceUniqueId(instance.getInstanceUid());
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
