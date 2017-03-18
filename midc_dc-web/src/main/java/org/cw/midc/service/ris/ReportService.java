package org.cw.midc.service.ris;

import org.cw.midc.entity.User;
import org.cw.midc.model.ris.Report;
import org.cw.midc.repository.ris.ReportRepository;
import org.cw.midc.util.CommonUtils;
import org.cw.midc.util.UserContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
	
	@Autowired
	private ReportRepository reportRepository;
	
	public void createReport(Report report)
	{
		User user = (User) UserContextUtil.getAttribute("currentUser");
		String userId = user.getUserId();
		
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
	
	public String getHighestRole()
	{
		return "SENIOR_DOCTOR";
	}

}
