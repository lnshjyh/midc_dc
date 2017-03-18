package org.cw.midc.service.ris;

import org.cw.midc.dto.ReportModifyDto;
import org.cw.midc.dto.ReportQueryDto;
import org.cw.midc.entity.User;
import org.cw.midc.model.ris.Report;
import org.cw.midc.model.ris.StudyInfo;
import org.cw.midc.repository.ris.ReportRepository;
import org.cw.midc.repository.ris.StudyInfoRepository;
import org.cw.midc.service.factory.DozerBeanMapperFactory;
import org.cw.midc.util.CommonUtils;
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
	
	public void createReport(Report report)
	{
		User user = (User) UserContextUtil.getAttribute("currentUser");
		
		StudyInfo studyInfo = studyInfoRepository.findOne(report.getStudyInfoId());
		
		if(studyInfo == null)
		{
			log.debug("No studyInfo found!");
			return;
		}
		
		String userId = "1234567";
		
		if("SENIOR_DOCTOR".equals(getHighestRole()))
		{
			report.setJuniorDoctorId(userId);
			report.setSeniorDoctorId(userId);
			studyInfo.setReportStatus("2");
		}
		else if("JUNIOR_DOCTOR".equals(getHighestRole()))
		{
			report.setJuniorDoctorId(userId);
			studyInfo.setReportStatus("1");
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
		
		if("SENIOR_DOCTOR".equals(getHighestRole()))
		{
			resultNew.setJuniorDoctorId(userId);
			studyInfo.setReportStatus("2");
		}
		else if("JUNIOR_DOCTOR".equals(getHighestRole()))
		{
			resultNew.setJuniorDoctorId(userId);
			studyInfo.setReportStatus("1");
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
	
	private String getHighestRole()
	{
		return "SENIOR_DOCTOR";
	}

}