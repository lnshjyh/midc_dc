package org.cw.midc.service.factory;

import org.cw.midc.auth.model.User;
import org.cw.midc.dto.UserCreateDto;
import org.springframework.stereotype.Service;

@Service
public class UserFactory {

	public User createUserFromDTO(UserCreateDto userCreateDto, String id)
	{
		User user = new User();
		user.setId(id);
		user.setUserName(userCreateDto.getUserName());
		user.setPassword(userCreateDto.getPassword());
		user.setFirstName(userCreateDto.getFirstName());
		user.setLastName(userCreateDto.getLastName());
		user.setEmail(userCreateDto.getEmail());
		user.setMobile(userCreateDto.getMobile());
		user.setDepartmentId("dataCenter");;
		user.setOperatorId(userCreateDto.getOperatorId());
		
		
		return user;
	}
	
}
