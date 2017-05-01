package org.cw.midc.controller.out.oauth;

import javax.servlet.http.HttpServletRequest;

import org.cw.midc.Response;
import org.cw.midc.dto.ReportQueryDto;
import org.cw.midc.entity.oauth.OauthAccessToken;
import org.cw.midc.service.ris.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;

@RestController
@RequestMapping("res/basic")
public class ReportOAuthController {
	
	@Autowired
	private ReportService reportService;
	
	@ResponseBody
	@GetMapping("report")
	public Response getReport(@RequestParam String studyInfoId, HttpServletRequest httpRequest)
	{
		Preconditions.checkNotNull(studyInfoId, "不能为空");
		Response response = new Response();
		OauthAccessToken obj = (OauthAccessToken)httpRequest.getAttribute("oauthToken");
		String clientId = obj.getClientId();
		ReportQueryDto report = reportService.getReportByHospital(studyInfoId, clientId);
		response.setData(report);
		response.setMsg("");
		return response;
	}
	
}
