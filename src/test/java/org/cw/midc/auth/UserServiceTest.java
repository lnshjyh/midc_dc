package org.cw.midc.auth;

import java.util.List;
import java.util.Set;

import org.cw.midc.MidcApplication;
import org.cw.midc.auth.model.Role;
import org.cw.midc.auth.model.User;
import org.cw.midc.auth.repository.RoleRepository;
import org.cw.midc.auth.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MidcApplication.class)
public class UserServiceTest {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
//	@Test
	public void createUserTest()
	{
		User user = new User();
		user.setId("12345");
		user.setUserName("zhangsan");
		user.setPassword("123456");
		userRepository.save(user);
	}
	
//	@Test
	public void findByUserNameTest()
	{
		User user = userRepository.findByUserName("zhangsan");
		Set<Role> roles = user.getRoles();
		roles.forEach(role -> {
			System.out.println(role.getRoleName());
		});
		System.out.println(user.getUserName());

	}
//	@Test
	public void addRoleTest()
	{
		User user = userRepository.findByUserName("zhangsan");
		Role role1 = new Role();
		role1.setId(1);
		role1.setRoleName("Admin");
		user.getRoles().add(role1);
		userRepository.save(user);
	}
	
//	@Test
	public void removeRoleTest()
	{
		User user = userRepository.findByUserName("zhangsan");
		System.out.println(user.getRoles().size());
		Role role1 = new Role();
		role1.setId(1);
		role1.setRoleName("Admin");
		user.getRoles().clear();
	    
		System.out.println(user.getRoles().size());
		userRepository.save(user);
	}
	
//	@Test
	public void updateRoleTest()
	{
		User user = userRepository.findByUserName("zhangsan");
		System.out.println(user.getRoles().size());
		user.getRoles().clear();
		
		Role role2 = new Role();
		role2.setId(1);
		Role role3 = new Role();
		role3.setId(2);
		user.getRoles().add(role2);
		user.getRoles().add(role3);
	    
		System.out.println(user.getRoles().size());
		userRepository.save(user);
	}
	@Test
	public void getRoleListTest()
	{
		Integer[] ids = {1,2};
		List<Role> roles = roleRepository.findByIdIn(ids);
		roles.forEach(role -> {
			System.out.println(role.getRoleName());
		});
	}
	
	
}
