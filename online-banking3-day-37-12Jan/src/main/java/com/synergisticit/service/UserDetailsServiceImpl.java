package com.synergisticit.service;


import java.util.Collection;
import java.util.HashSet;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Role;
import com.synergisticit.domain.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username:" +username);
		com.synergisticit.domain.User u = userService.findUserByUsername(username);
		Collection<GrantedAuthority> auth = new HashSet<>();
		if(u != null) {
			System.out.println("u from DB: "+ u.getUsername());
			for(Role r:u.getRoles() ) {
				System.out.println(r.getName());
				auth.add(new SimpleGrantedAuthority(r.getName()));
			}
			
		}
		return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), auth);
	}

}
