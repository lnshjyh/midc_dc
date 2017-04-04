package org.cw.midc.service.ris;

import java.util.ArrayList;
import java.util.List;

import org.cw.midc.dto.RisInfoDto;
import org.cw.midc.model.Hospital;
import org.cw.midc.model.oauth.OauthAccessToken;
import org.cw.midc.model.ris.StudyInfo;
import org.cw.midc.repository.HospitalRepository;
import org.cw.midc.repository.ris.StudyInfoRepository;
import org.cw.midc.service.factory.RisFactory;
import org.cw.midc.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RisService {

	@Autowired
	private RisFactory risFactory;

	@Autowired
	private StudyInfoRepository studyInfoRepository;

	@Autowired
	private HospitalRepository hospitalRepository;

	public void createRisInfo(RisInfoDto risInfoDto, String clientId) {
		List<Hospital> hospitalList = hospitalRepository.findByClientId(clientId);
		if(hospitalList == null || hospitalList.size() == 0)
		{
			return;
		}
		String hospitalId = hospitalList.get(0).getHospId();
		risInfoDto.setHospitalId(hospitalId);
		StudyInfo studyInfo = risFactory.createStudyInfoFromDTO(risInfoDto);
		studyInfoRepository.save(studyInfo);
	}

	public List<String> getStudyInfoIdsFinishedAndUnDownloadedReport(String clientId) {
		List<Hospital> hospitalList = hospitalRepository.findByClientId(clientId);
		if(hospitalList == null || hospitalList.size() == 0)
		{
			return null;
		}
		String hospitalId = hospitalList.get(0).getHospId();
		List<StudyInfo> studyInfos = studyInfoRepository.findByHospitalIdAndReportStatusAndTransportStatus(hospitalId,
				Constants.REPORT_STATUS_APPROVED,
				Constants.STUDYINFO_TRANS_STATUS_B2C);
		
		List<String> result = new ArrayList<String>();;
		
		//返回的是原始的studyInfoId，来自于基层机构
		studyInfos.forEach(studyinfo->{
			result.add(studyinfo.getOrginalStudyInfoId());
		});
		return result;		
	}

}
