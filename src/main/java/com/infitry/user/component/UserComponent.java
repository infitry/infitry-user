package com.infitry.user.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infitry.user.entity.User;
import com.infitry.user.repository.UserRepository;

@Component
public class UserComponent {
	
	@Autowired
	UserRepository userRepository;
	
	public User getUser(long userSeq) {
		return userRepository.getOne(userSeq);
	}
	
	public User getUserById(String id) {
		return userRepository.findUserById(id);
	}
}
