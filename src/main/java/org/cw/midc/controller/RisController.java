package org.cw.midc.controller;

import org.cw.midc.dto.RisInfoDto;
import org.cw.midc.service.ris.RisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
public class RisController {

	private static final Logger log = LoggerFactory.getLogger(RisController.class);
	
	@Autowired
	private RisService risService;
	
	@RequestMapping(value = "/risInfo", method = RequestMethod.POST)
	public void createRisInfo(@RequestBody RisInfoDto risInfoDto)
	{
		log.debug("ok");
		risService.createRisInfo(risInfoDto);
	}
	
	public void modifyRisInfo()
	{
		
	}
}
