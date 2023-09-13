package com.deneme.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deneme.demo.entities.User;
import com.deneme.demo.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

	//Repository'i direkt controller'a bağlamak tercih edilen bir şey değil
	//private UserRepository userRepository;
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping 
	public User createUser(@RequestBody User newUser) {
		return userService.saveOneUser(newUser);
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId) {
		//custom exception
		return userService.getOneUser(userId);
	}
	
	@GetMapping("/deneme")
	public List<User> getDenemeUser() {
		//custom exception
		return userService.getDenemeUser();
	}
	
	//Update 
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId, @RequestBody User updateUser) {
		return userService.updateOneUser(userId, updateUser);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userService.deleteById(userId);
	}
}
