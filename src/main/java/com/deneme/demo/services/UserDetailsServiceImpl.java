package com.deneme.demo.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.deneme.demo.entities.User;
import com.deneme.demo.repos.UserRepository;
import com.deneme.demo.secutiry.JwtUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;
	
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		return JwtUserDetails.creaete(user);
	}
	
	public UserDetails loadUserById(Long id) {
		User user = userRepository.findById(id).get();
		return JwtUserDetails.creaete(user);
	}

}
