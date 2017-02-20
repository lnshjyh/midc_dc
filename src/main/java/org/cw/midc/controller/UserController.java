package org.cw.midc.controller;

import org.cw.midc.dto.UserCreateDto;
import org.cw.midc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "user", method = RequestMethod.POST)
	public void createUser(@RequestBody UserCreateDto userCreateDto)
	{
		log.debug(userCreateDto.getUserName());
		userService.createUser(userCreateDto);
	}
	

}
