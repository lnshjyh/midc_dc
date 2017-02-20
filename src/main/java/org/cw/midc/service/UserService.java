package org.cw.midc.service;

import org.cw.midc.auth.model.User;
import org.cw.midc.auth.repository.UserRepository;
import org.cw.midc.dto.UserCreateDto;
import org.cw.midc.service.factory.UserFactory;
import org.cw.midc.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserFactory userFactory;
	
	@Autowired
	private UserRepository userRepository;

	public void createUser(UserCreateDto userCreateDto)
	{
		String userId = CommonUtils.generateId();
		User user = userFactory.createUserFromDTO(userCreateDto, userId);
		//check if userName or mobile or email exist
		userRepository.save(user);
	}
}
