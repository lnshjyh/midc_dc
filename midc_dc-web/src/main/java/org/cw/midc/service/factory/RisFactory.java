package org.cw.midc.service.factory;

import java.util.HashSet;
import java.util.Set;

import org.cw.midc.dto.RisInfoDto;
import org.cw.midc.model.ris.Patient;
import org.cw.midc.model.ris.StudyCheckItemPosition;
import org.cw.midc.model.ris.StudyInfo;
import org.cw.midc.util.CommonUtils;
import org.springframework.stereotype.Service;

@Service
public class RisFactory {

	public StudyInfo createStudyInfoFromDTO(RisInfoDto risInfoDto)
	{
		String key = risInfoDto.getHospitalId() + risInfoDto.getStudyInfoId();
		StudyInfo studyInfo = new StudyInfo(key,
				risInfoDto.getAge(), 
				risInfoDto.getAgeUnit(), 
				risInfoDto.getDeviceId(), 
				risInfoDto.getPrediagnose(),
				risInfoDto.getAbstractHistory(),
				risInfoDto.getStudyDescription(),
				risInfoDto.getHospitalId());
		studyInfo.setOrginalStudyInfoId(risInfoDto.getStudyInfoId());
		studyInfo.setClinicalManifest(risInfoDto.getClinicalManifest());
		studyInfo.setStudyDemand(risInfoDto.getStudyDemand());
		studyInfo.setApplyDoctorName(risInfoDto.getApplyDoctorName());
		studyInfo.setApplyDepartmentName(risInfoDto.getApplyDepartmentName());
		studyInfo.setApplyTime(risInfoDto.getApplyTime());
		Patient patient = createPatientFromDTO(risInfoDto);
		studyInfo.setPatient(patient);
		
		//create checkitem and positon set
		if(risInfoDto.getPositionChecks() != null && !risInfoDto.getPositionChecks().isEmpty())
		{
			Set<StudyCheckItemPosition> studyCheckItemPositions = new HashSet<StudyCheckItemPosition>();
			risInfoDto.getPositionChecks().forEach(positionCheckDto -> {
				StudyCheckItemPosition studyCheckItemPosition = new StudyCheckItemPosition();
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
