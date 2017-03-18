package org.cw.midc.controller;

import org.cw.midc.Response;
import org.cw.midc.dto.RisInfoDto;
import org.cw.midc.service.ris.RisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;

@RestController
@Scope("prototype")
public class RisController {

	private static final Logger log = LoggerFactory.getLogger(RisController.class);
	
	@Autowired
	private RisService risService;
	
	@PostMapping("/out/risInfo")
	@ResponseBody
	public Response createRisInfo(@RequestBody RisInfoDto risInfoDto)
	{
		Preconditions.checkNotNull(risInfoDto, "不能为空");
		Response response = new Response();
		risInfoDto.setHospitalId("1001");
		risService.createRisInfo(risInfoDto);
		response.setMsg("创建成功");
		return response;
	}
	
	public void modifyRisInfo()
	{
		
	}
}
