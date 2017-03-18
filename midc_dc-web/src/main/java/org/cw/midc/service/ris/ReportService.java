package org.cw.midc.service.ris;

import org.cw.midc.entity.User;
import org.cw.midc.model.ris.Report;
import org.cw.midc.model.ris.StudyInfo;
import org.cw.midc.repository.ris.ReportRepository;
import org.cw.midc.repository.ris.StudyInfoRepository;
import org.cw.midc.util.CommonUtils;
import org.cw.midc.util.UserContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
	
	@Autowired
	private ReportRepository reportRepository;
	
	private StudyInfoRepository studyInfoRepository;
	
	public void createReport(Report report)
	{
		User user = (User) UserContextUtil.getAttribute("currentUser");
//		String userId = user.getUserId();
		
//		if("SENIOR_DOCTOR".equals(getHighestRole()))
//		{
//			report.setSeniorDoctorId(userId);
//		}
//		else if("JUNIOR_DOCTOR".equals(getHighestRole()))
//		{
//			report.setJuniorDoctorId(userId);
//		}
//		else
//		{
//			return;
//		}
		report.setId(CommonUtils.generateId());
		reportRepository.save(report);
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
