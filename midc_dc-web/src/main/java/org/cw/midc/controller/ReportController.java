package org.cw.midc.controller;

import org.cw.midc.Response;
import org.cw.midc.model.ris.Report;
import org.cw.midc.service.ris.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Preconditions;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@ResponseBody
	@PostMapping("report")
	public Response createReport(@RequestBody Report report)
	{
		Preconditions.checkNotNull(report, "不能为空");
		Response response = new Response();
		reportService.createReport(report);
		response.setMsg("创建报告成功");
		return response;
	}
	
	@ResponseBody
	@GetMapping("report")
	public Response getReport(@RequestParam String studyInfoId)
	{
		Preconditions.checkNotNull(studyInfoId, "不能为空");
		Response response = new Response();
//		reportService.createReport(report);
//		response.setMsg("创建报告成功");
		return response;
	}

}
