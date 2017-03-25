package org.cw.midc.service.ris;

import java.util.List;

import org.cw.midc.dto.ReportModifyDto;
import org.cw.midc.dto.ReportQueryDto;
import org.cw.midc.entity.User;
import org.cw.midc.model.Hospital;
import org.cw.midc.model.ris.Report;
import org.cw.midc.model.ris.StudyInfo;
import org.cw.midc.repository.HospitalRepository;
import org.cw.midc.repository.ris.ReportRepository;
import org.cw.midc.repository.ris.StudyInfoRepository;
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
	private ReportRepository reportRepository;
	
	@Autowired
	private StudyInfoRepository studyInfoRepository;
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	public void createReport(Report report)
	{
		User user = (User) UserContextUtil.getAttribute("currentUser");
		
		StudyInfo studyInfo = studyInfoRepository.findOne(report.getStudyInfoId());
		
		if(studyInfo == null)
		{
			log.debug("No studyInfo found!");
			return;
		}
		
		String userId = user.getUserId();
		
		if("ROLE_SENIOR_DOC".equals(getHighestRole()))
		{
			report.setJuniorDoctorId(userId);
			report.setSeniorDoctorId(userId);
			studyInfo.setReportStatus(Constants.REPORT_STATUS_APPROVED);
		}
		else if("ROLE_JUNIOR_DOC".equals(getHighestRole()))
		{
			report.setJuniorDoctorId(userId);
			studyInfo.setReportStatus(Constants.REPORT_STATUS_PRE_DIAGNOSE);
		}
		else
		{
			return;
		}
		report.setId(CommonUtils.generateId());
		studyInfo.setReport(report);
		studyInfoRepository.save(studyInfo);
//		reportRepository.save(report);
		
	}
	
	public void modifyReport(ReportModifyDto reportModifyDto)
	{
		StudyInfo studyInfo = studyInfoRepository.findOne(reportModifyDto.getStudyInfoId());
		if(studyInfo == null || studyInfo.getReport() == null)
		{
			return;
		}
		
		String userId = "1234567";
		Report report = studyInfo.getReport();
		String reportId = report.getId();
		Report resultNew = DozerBeanMapperFactory.getMapper().map(reportModifyDto, Report.class);
		resultNew.setId(reportId);
		
		if("ROLE_SENIOR_DOC".equals(getHighestRole()))
		{
			resultNew.setJuniorDoctorId(userId);
			studyInfo.setReportStatus(Constants.REPORT_STATUS_APPROVED);
		}
		else if("ROLE_JUNIOR_DOC".equals(getHighestRole()))
		{
			resultNew.setJuniorDoctorId(userId);
			studyInfo.setReportStatus(Constants.REPORT_STATUS_PRE_DIAGNOSE);
		}
		else
		{
			return;
		}
		
		studyInfo.setReport(resultNew);
		studyInfoRepository.save(studyInfo);
		
		
	}
	
	public ReportQueryDto getReportByStudyInfoId(String studyInfoId)
	{
		StudyInfo studyInfo = studyInfoRepository.findOne(studyInfoId);
		if(studyInfo == null || studyInfo.getReport() == null)
		{
			return null;
		}
		
		ReportQueryDto result = DozerBeanMapperFactory.getMapper().map(studyInfo.getReport(), ReportQueryDto.class);
		
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
		StudyInfo studyInfo = studyInfoRepository.findByOrginalStudyInfoIdAndHospitalId(studyInfoId, hospitalId);
		if(studyInfo == null || studyInfo.getReport() == null)
		{
			return null;
		}
		
		ReportQueryDto result = DozerBeanMapperFactory.getMapper().map(studyInfo.getReport(), ReportQueryDto.class);
		
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
