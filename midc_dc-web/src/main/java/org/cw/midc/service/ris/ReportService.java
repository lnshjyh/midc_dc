package org.cw.midc.service.ris;

import org.cw.midc.entity.User;
import org.cw.midc.model.ris.Report;
import org.cw.midc.model.ris.StudyInfo;
import org.cw.midc.repository.ris.ReportRepository;
import org.cw.midc.repository.ris.StudyInfoRepository;
import org.cw.midc.util.CommonUtils;
import org.cw.midc.util.UserContextUtil;
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
	
	public Report getReportByStudyInfoId(String studyInfoId)
	{
		StudyInfo studyInfo = studyInfoRepository.findOne(studyInfoId);
		if(studyInfo == null || studyInfo.getReport() == null)
		{
			return null;
		}
		
		return studyInfo.getReport();		
	}
	
	private String getHighestRole()
	{
		return "SENIOR_DOCTOR";
	}

}
