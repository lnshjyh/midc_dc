package org.cw.midc.service.factory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.cw.midc.dao.CheckItemDao;
import org.cw.midc.dao.PositionTypeDao;
import org.cw.midc.dto.RisInfoDto;
import org.cw.midc.entity.CheckItem;
import org.cw.midc.entity.Patient;
import org.cw.midc.entity.Positiontype;
import org.cw.midc.entity.StudyCheckPos;
import org.cw.midc.entity.StudyInfo;
import org.cw.midc.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RisFactory {
	
	@Autowired
	private PositionTypeDao positionTypeDao;
	
	@Autowired
	private CheckItemDao checkItemDao;

	public StudyInfo createStudyInfoFromDTO(RisInfoDto risInfoDto)
	{
		String key = risInfoDto.getHospitalId() + risInfoDto.getStudyInfoId();
		StudyInfo studyInfo = new StudyInfo(key,
				risInfoDto.getAge(), 
				risInfoDto.getAgeUnit(), 
				risInfoDto.getDeviceType(), 
				risInfoDto.getPrediagnose(),
				risInfoDto.getAbstractHistory(),
				risInfoDto.getStudyDescription(),
				risInfoDto.getHospitalId());
		studyInfo.setOrgStudyinfoId(risInfoDto.getStudyInfoId());
		studyInfo.setClinicalManifest(risInfoDto.getClinicalManifest());
		studyInfo.setStudyDemand(risInfoDto.getStudyDemand());
		studyInfo.setApplyDocName(risInfoDto.getApplyDoctorName());
		studyInfo.setApplyDepName(risInfoDto.getApplyDepartmentName());
		studyInfo.setTransStatus("1");
		Patient patient = createPatientFromDTO(risInfoDto);
		studyInfo.setPatId(patient.getPatId());
		studyInfo.setPatient(patient);
		
		
		//create checkitem and positon set
		if(risInfoDto.getPositionChecks() != null && !risInfoDto.getPositionChecks().isEmpty())
		{
			StringBuilder positonCheckItemStr = new StringBuilder("[");
			List<StudyCheckPos> studyCheckItemPositions = new ArrayList<>();
			risInfoDto.getPositionChecks().forEach(positionCheckDto -> {
				positonCheckItemStr.append("");
				StudyCheckPos studyCheckItemPosition = new StudyCheckPos();
				studyCheckItemPosition.setStudyinfoId(key);
				if(!StringUtils.isEmpty(positionCheckDto.getPosition()))
				{
					Positiontype position = positionTypeDao.findUnique("getById", Integer.parseInt(positionCheckDto.getPosition()));
					
					studyCheckItemPosition.setPosition(positionCheckDto.getPosition());
					if(position != null)
					{
					    positonCheckItemStr.append(position.getPositiontypeName());
					}
					positonCheckItemStr.append(",");
				}

				if(!StringUtils.isEmpty(positionCheckDto.getCheckItem()))
				{
					studyCheckItemPosition.setCheckItem(positionCheckDto.getCheckItem());
					CheckItem checkItem = checkItemDao.findUnique("getById",Integer.parseInt(positionCheckDto.getCheckItem()));
					studyCheckItemPosition.setSubPosition(positionCheckDto.getSubPosition());
					if(checkItem != null)
					{
					    positonCheckItemStr.append(checkItem.getCheckitemName());
					}
					studyCheckItemPositions.add(studyCheckItemPosition);
					positonCheckItemStr.append(";");
				}

			});
			positonCheckItemStr.append("]");
			studyInfo.setPositionCheckitem(positonCheckItemStr.toString());
			studyInfo.setStudyCheckPoses(studyCheckItemPositions);
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
