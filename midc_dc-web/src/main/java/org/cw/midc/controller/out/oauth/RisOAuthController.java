package org.cw.midc.controller.out.oauth;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.cw.midc.Response;
import org.cw.midc.dto.RisInfoDto;
import org.cw.midc.entity.oauth.OauthAccessToken;
import org.cw.midc.service.DicomFileService;
import org.cw.midc.service.ris.RisService;
import org.cw.midc.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;

@RestController
@RequestMapping("res/basic")
public class RisOAuthController {
	
	private static final Logger log = LoggerFactory.getLogger(RisOAuthController.class);
	
	@Autowired
	private RisService risService;
	
	@RequestMapping("reportfinishedStudyInfoIds")
	public Response getStudyInfoIdsFinishedReport(HttpServletRequest httpRequest)
	{
		Response response = new Response();	
		OauthAccessToken obj = (OauthAccessToken)httpRequest.getAttribute("oauthToken");
		String clientId = obj.getClientId();
		List<String> studyInfoIds = risService.getStudyInfoIdsFinishedAndUnDownloadedReport(clientId);
		response.setData(studyInfoIds);
		return response;
		
	}
	
	@PostMapping("/risInfo")
	public Response createRisInfo(@RequestBody RisInfoDto risInfoDto, HttpServletRequest httpRequest)
	{
		Preconditions.checkNotNull(risInfoDto, "不能为空");
		Response response = new Response();
		OauthAccessToken obj = (OauthAccessToken)httpRequest.getAttribute("oauthToken");
		risService.createRisInfo(risInfoDto, obj.getClientId());
		response.setMsg("创建成功");
		return response;
	}
	

}
