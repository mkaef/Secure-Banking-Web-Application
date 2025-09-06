package com.synergisticit.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.synergisticit.domain.Role;
import com.synergisticit.domain.User;
import com.synergisticit.service.RoleService;
import com.synergisticit.service.UserService;
@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
	@Autowired RoleService roleService;
	@Autowired UserService userService;
	@Autowired BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void run(String... args) throws Exception {
		if(userService.findUserByUsername("Admin")== null) {
			Role r = new Role();
			r.setName("Admin");
			r.setRoleId(1L);
			roleService.saveRole(r);
			User user = new User();
			user.setUsername("Admin");
			user.setUserId(1L);
			user.setPassword(bCryptPasswordEncoder.encode("1234"));
			user.setEmail("admin@gmail.com");
			userService.save(user);
		}
		
	}

}
