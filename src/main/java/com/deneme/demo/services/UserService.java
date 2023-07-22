package com.deneme.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.deneme.demo.entities.User;
import com.deneme.demo.repos.UserRepository;

@Service
public class UserService {
	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User saveOneUser(User newUser) {
		return userRepository.save(newUser);
	}

	public User getOneUser(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public User updateOneUser(Long userId, User updateUser) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User foundUser = user.get();
			//String name = updateUser.getUserName();
			foundUser.setUserName(updateUser.getUserName());
			foundUser.setPassword(updateUser.getPassword());
			userRepository.save(foundUser);
			return foundUser;
		}
		else {
			
			return null;
		}
	}

	public void deleteById(Long userId) {
		userRepository.deleteById(userId);
	}
	
	
}
