package org.cw.midc.service.ris;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cw.midc.dao.ReportDao;
import org.cw.midc.dao.StudyInfoDao;
import org.cw.midc.dto.ReportModifyDto;
import org.cw.midc.dto.ReportQueryDto;
import org.cw.midc.entity.User;
import org.cw.midc.model.Hospital;
import org.cw.midc.entity.Report;
import org.cw.midc.entity.StudyInfo;
import org.cw.midc.repository.HospitalRepository;
import org.cw.midc.service.factory.DozerBeanMapperFactory;
import org.cw.midc.util.CommonUtils;
import org.cw.midc.util.Constants;
import org.cw.midc.util.UserContextUtil;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
	
	private static final Logger log = LoggerFactory.getLogger(ReportService.class);

	
	@Autowired
	private ReportDao reportDao;

	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	private StudyInfoDao studyInfoDao;
	
	public void createReport(Report report)
	{
		User user = (User) UserContextUtil.getAttribute("currentUser");
		
//		StudyInfo studyInfo = studyInfoRepository.findOne(report.getStudyInfoId());
		StudyInfo studyInfo = studyInfoDao.findUnique("getById", report.getStudyinfoId());
		
		if(studyInfo == null)
		{
			log.debug("No studyInfo found!");
			return;
		}
		
		String userId = user.getUserId();
		
		if("ROLE_SENIOR_DOC".equals(getHighestRole()))
		{
			report.setjDocId(userId);
			report.setsDocId(userId);
			studyInfo.setRptStatus(Constants.REPORT_STATUS_APPROVED);
		}
		else if("ROLE_JUNIOR_DOC".equals(getHighestRole()))
		{
			report.setjDocId(userId);
			studyInfo.setRptStatus(Constants.REPORT_STATUS_PRE_DIAGNOSE);
		}
		else
		{
			return;
		}
		report.setRptId((CommonUtils.generateId()));
        //[未写] 更新 studyInfo表的报告状态
		
		//插入报告表
		reportDao.save(report);
		
	}
	
	public void modifyReport(ReportModifyDto reportModifyDto)
	{
//		StudyInfo studyInfo = studyInfoRepository.findOne(reportModifyDto.getStudyInfoId());
		StudyInfo studyInfo = studyInfoDao.findUnique("getById", reportModifyDto.getStudyInfoId());
		if(studyInfo == null)
		{
			return;
		}
		User user = (User) UserContextUtil.getAttribute("currentUser");
		
		String userId = user.getUserId();
		Report report = reportDao.findUnique("selectByStudyInfoId", reportModifyDto.getStudyInfoId());
		String reportId = report.getRptId();
		Report resultNew = DozerBeanMapperFactory.getMapper().map(reportModifyDto, Report.class);
		resultNew.setRptId(reportId);
		
		if("ROLE_SENIOR_DOC".equals(getHighestRole()))
		{
			resultNew.setsDocId(userId);
			studyInfo.setRptStatus(Constants.REPORT_STATUS_APPROVED);
		}
		else if("ROLE_JUNIOR_DOC".equals(getHighestRole()))
		{
			resultNew.setjDocId(userId);
			studyInfo.setRptStatus(Constants.REPORT_STATUS_PRE_DIAGNOSE);
		}
		else
		{
			return;
		}
		
		//更新报告表
//		studyInfoRepository.save(studyInfo);
		
		
	}
	
	public ReportQueryDto getReportByStudyInfoId(String studyInfoId)
	{
//		StudyInfo studyInfo = studyInfoRepository.findOne(studyInfoId);
		Report rport = reportDao.findUnique("selectByStudyInfoId", studyInfoId);
		ReportQueryDto result = new ReportQueryDto();
		result.setId(rport.getRptId());
		result.setDescription(rport.getDescription());
		result.setDiagnosis(rport.getDiagnosis());
		result.setAdvice(rport.getAdvice());
		result.setJuniorDoctorId(rport.getjDocId());
		result.setSeniorDoctorId(rport.getsDocId());
		result.setDirectoDoctorId(rport.getdDocId());
		result.setCreateTime(rport.getCreateTime());
		result.setUpdateTime(rport.getUpdateTime());
		return result;		
	}
	
	public ReportQueryDto getReportByHospital(String studyInfoId, String clientId)
	{
		List<Hospital> hospitalList = hospitalRepository.findByClientId(clientId);
		if(hospitalList == null || hospitalList.size() == 0)
		{
			return null;
		}
		String hospitalId = hospitalList.get(0).getHospId();
		Map param = new HashMap<>();
		param.put("hospitalId", hospitalId);
		param.put("orginalStudyInfoId", studyInfoId);
		StudyInfo studyInfo = studyInfoDao.findUnique("getByOrginalStudyInfoIdAndHospitalId", param);
		if(studyInfo == null)
		{
			return null;
		}
		
		//更新传输状态
		studyInfo.setTransStatus(Constants.STUDYINFO_TRANS_STATUS_C2B);
		studyInfo.setUpdateTime(new Date());
//		studyInfoRepository.save(studyInfo);
		studyInfoDao.update("update", studyInfo);
		
//		ReportQueryDto result = DozerBeanMapperFactory.getMapper().map(studyInfo.getReport(), ReportQueryDto.class);
		ReportQueryDto result = null;
		return result;		
	}
	
	private String getHighestRole()
	{
		List<String> roles = (List<String>)UserContextUtil.getAttribute("roles");
		String doctorRoleHighest = null;
		if(roles.indexOf("ROLE_SENIOR_DOC") != -1)
		{
			return "ROLE_SENIOR_DOC";
		}
		
		if(roles.indexOf("ROLE_JUNIOR_DOC") != -1)
		{
			return "ROLE_JUNIOR_DOC";
		}		
		return null;
	}

}
