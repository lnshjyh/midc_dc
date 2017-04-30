package org.cw.midc.service.ris;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.cw.midc.dao.StudyInfoDao;
import org.cw.midc.dto.RisInfoDto;
import org.cw.midc.model.Hospital;
import org.cw.midc.model.oauth.OauthAccessToken;
import org.cw.midc.entity.StudyInfo;
import org.cw.midc.entity.StudyInfoEntity;
import org.cw.midc.repository.HospitalRepository;
import org.cw.midc.service.factory.RisFactory;
import org.cw.midc.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;

@Service
public class RisService {

	@Autowired
	private RisFactory risFactory;

	@Resource
    private StudyInfoDao studyInfoDao;
	
//	@Resource
//    private StudyInfoOperateDao studyInfoOperateDao;

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
		studyInfoDao.save(studyInfo);
	}

	public List<String> getStudyInfoIdsFinishedAndUnDownloadedReport(String clientId) {
		List<Hospital> hospitalList = hospitalRepository.findByClientId(clientId);
		if(hospitalList == null || hospitalList.size() == 0)
		{
			return null;
		}
		String hospitalId = hospitalList.get(0).getHospId();
		Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("hospitalId", hospitalId);
        paramMap.put("reportStatus", Constants.REPORT_STATUS_APPROVED);
        paramMap.put("transportStatus", Constants.STUDYINFO_TRANS_STATUS_B2C);
		List<StudyInfo> studyInfos = studyInfoDao.find("getListByHospitalIdAndReportStatusAndTransportStatus",paramMap);
		
		List<String> result = new ArrayList<String>();;
		
		//返回的是原始的studyInfoId，来自于基层机构
		studyInfos.forEach(studyinfo->{
			result.add(studyinfo.getOrgStudyinfoId());
		});
		return result;		
	}

}
