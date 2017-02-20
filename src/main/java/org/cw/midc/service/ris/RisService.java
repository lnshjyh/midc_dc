package org.cw.midc.service.ris;

import org.cw.midc.dto.RisInfoDto;
import org.cw.midc.model.ris.StudyInfo;
import org.cw.midc.repository.ris.StudyInfoRepository;
import org.cw.midc.service.factory.RisFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RisService {

	@Autowired
	private RisFactory risFactory;
	
	@Autowired
	private StudyInfoRepository studyInfoRepository;
	
	public void createRisInfo(RisInfoDto risInfoDto)
	{
		StudyInfo studyInfo = risFactory.createStudyInfoFromDTO(risInfoDto);
		studyInfoRepository.save(studyInfo);
	} 
		
}
