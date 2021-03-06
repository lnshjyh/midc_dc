package org.cw.midc.service.factory;

import java.util.HashSet;
import java.util.Set;

import org.cw.midc.dto.RisInfoDto;
import org.cw.midc.model.ris.Patient;
import org.cw.midc.model.ris.StudyCheckPos;
import org.cw.midc.model.ris.StudyInfo;
import org.cw.midc.util.CommonUtils;
import org.springframework.stereotype.Service;

@Service
public class RisFactory {

	public StudyInfo createStudyInfoFromDTO(RisInfoDto risInfoDto)
	{
		String key = CommonUtils.generateId();
		StudyInfo studyInfo = new StudyInfo(key,
				risInfoDto.getAge(), 
				risInfoDto.getAgeUnit(), 
				risInfoDto.getDeviceId(), 
				risInfoDto.getPrediagnose(),
				risInfoDto.getAbstractHistory(),
				risInfoDto.getStudyDescription(),
				risInfoDto.getBranchId());
		Patient patient = createPatientFromDTO(risInfoDto);
		studyInfo.setPatient(patient);
		
		//create checkitem and positon set
		if(risInfoDto.getPositionChecks() != null && !risInfoDto.getPositionChecks().isEmpty())
		{
			Set<StudyCheckPos> studyCheckItemPositions = new HashSet<StudyCheckPos>();
			risInfoDto.getPositionChecks().forEach(positionCheckDto -> {
				StudyCheckPos studyCheckItemPosition = new StudyCheckPos();
				studyCheckItemPosition.setCheckItem(positionCheckDto.getCheckItem());
				studyCheckItemPosition.setPosition(positionCheckDto.getPosition());
				studyCheckItemPosition.setSubPosition(positionCheckDto.getSubPosition());
				studyCheckItemPositions.add(studyCheckItemPosition);
			});
			studyInfo.setStudyCheckItemPositions(studyCheckItemPositions);
		}
		
		
		return studyInfo;
	}
	
	public Patient createPatientFromDTO(RisInfoDto risInfoDto)
	{
		String key = CommonUtils.generateId();
		Patient patient = new Patient(key, 
				risInfoDto.getPatientName(), 
				risInfoDto.getPatientSpellName(), 
				risInfoDto.getBirthday(), 
				risInfoDto.getSex(), 
				risInfoDto.getPatientType(),
				risInfoDto.getIdNumber(), 
				risInfoDto.getPhoneNumber(), 
				risInfoDto.getNationality(), 
				risInfoDto.getAddress(), 
				risInfoDto.getPatientCardId(), 
				"");
		
		return patient;
	}

}
