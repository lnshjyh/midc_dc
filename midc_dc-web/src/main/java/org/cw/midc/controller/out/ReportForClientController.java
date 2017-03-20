package org.cw.midc.controller.out;

import org.cw.midc.Response;
import org.cw.midc.dto.ReportModifyDto;
import org.cw.midc.dto.ReportQueryDto;
import org.cw.midc.model.ris.Report;
import org.cw.midc.service.ris.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Preconditions;

@Controller
@RequestMapping("out")
public class ReportForClientController {
	
	@Autowired
	private ReportService reportService;
	
	@ResponseBody
	@PostMapping("report")
	public Response createReport(@RequestBody Report report)
	{
		Preconditions.checkNotNull(report, "不能为空");
		Response response = new Response();
		reportService.createReport(report);
		response.setMsg("Create report successfully!");
		return response;
	}
	
	@ResponseBody
	@GetMapping("report")
	public Response getReport(@RequestParam String studyInfoId)
	{
		Preconditions.checkNotNull(studyInfoId, "不能为空");
		Response response = new Response();
		ReportQueryDto report = reportService.getReportByStudyInfoId(studyInfoId);
		response.setData(report);
		response.setMsg("");
		return response;
	}
	
	@ResponseBody
	@PutMapping("report")
	public Response modifyReport(@RequestBody ReportModifyDto reportModifyDto)
	{
		Preconditions.checkNotNull(reportModifyDto, "不能为空");
		Response response = new Response();
		reportService.modifyReport(reportModifyDto);;
		response.setMsg("Modify report successfully!");
		return response;
	}

}
