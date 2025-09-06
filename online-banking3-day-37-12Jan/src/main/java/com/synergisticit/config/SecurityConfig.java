package com.synergisticit.config;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@Configuration
@EnableWebSecurity

public class SecurityConfig {
     UserDetailsService userDetailsService;
	@Autowired BCryptPasswordEncoder bCrypt;
	
	@Bean
	InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		List<UserDetails> users = new ArrayList<>();
		
		List<GrantedAuthority> authority1 = new ArrayList<>();
		authority1.add(new SimpleGrantedAuthority("Admin"));
		authority1.add(new SimpleGrantedAuthority("User"));
		UserDetails user1 = new User("andrew",bCrypt.encode("andrew"),authority1);
		users.add(user1);
		
		List<GrantedAuthority> authority2 = new ArrayList<>();
		authority2.add(new SimpleGrantedAuthority("Admin"));
		authority2.add(new SimpleGrantedAuthority("HR"));
		authority2.add(new SimpleGrantedAuthority("Programer"));
		UserDetails user2 = new User("franck",bCrypt.encode("franck"),authority2);
		users.add(user2);
		
		List<GrantedAuthority> authority3 = new ArrayList<>();
		authority3.add(new SimpleGrantedAuthority("User"));
		authority3.add(new SimpleGrantedAuthority("Programer"));
		UserDetails user3 = new User("tino",bCrypt.encode("tino"),authority3);
		users.add(user3);
		
		List<GrantedAuthority> authority4 = new ArrayList<>();
		authority4.add(new SimpleGrantedAuthority("Admin"));
		authority4.add(new SimpleGrantedAuthority("HR"));
		UserDetails user4 = new User("tim",bCrypt.encode("tim"),authority4);
		users.add(user4);
		
		List<GrantedAuthority> authority5 = new ArrayList<>();
		authority5.add(new SimpleGrantedAuthority("User"));
		authority5.add(new SimpleGrantedAuthority("Sr Programmer"));
		UserDetails user5 = new User("paul",bCrypt.encode("paul"),authority5);
		users.add(user5);
		
		return new InMemoryUserDetailsManager(users);
	}
	
	@Bean
	DaoAuthenticationProvider daoAuthenticationProvider() {
	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
	daoAuthenticationProvider.setUserDetailsService(inMemoryUserDetailsManager());
	daoAuthenticationProvider.setPasswordEncoder(bCrypt);
	
		return  daoAuthenticationProvider;
	}
	
	
	
	
	 

}
