package com.synergisticit.service;

import java.util.List;



import com.synergisticit.domain.User;

public interface  UserService {
	
	
public User save(User user);

public User findById(Long UserId);

public List<User>findAll();

public User updateById(Long UserId);

public void deleteById(Long UserId);

public User findUserByUsername(String username);

}
