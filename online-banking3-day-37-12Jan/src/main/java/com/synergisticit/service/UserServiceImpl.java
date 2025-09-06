package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.User;
import com.synergisticit.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired UserRepository userRepository;
	@Autowired BCryptPasswordEncoder bCrypt;

	@Override
	public User save(User user) {
		
	String pwd =	bCrypt.encode(user.getPassword());
	user.setPassword(pwd);
	
		return userRepository.save(user);
	}

	@Override
	public User findById(Long UserId) {
	Optional<User> optional =	userRepository.findById(UserId);
	if(optional.isPresent()) {
		return optional.get();
	}
		return null;
	}

	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public User updateById(Long UserId) {
		
		Optional<User> optional =	userRepository.findById(UserId);
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}

	@Override
	public void deleteById(Long UserId) {
		userRepository.deleteById(UserId);
		
	}

	@Override
	public User findUserByUsername(String username) {
		
		return userRepository.findUserByUsername(username);
	}

}
