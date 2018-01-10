package com.jstack.spring.springsecserver.service;

import java.net.UnknownServiceException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jstack.spring.springsecserver.model.CustomUserDetails;
import com.jstack.spring.springsecserver.model.Users;
import com.jstack.spring.springsecserver.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsersRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Users> usersOptional = userRepository.findByName(username);
		
		usersOptional
				.orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
		
		return usersOptional.map(CustomUserDetails::new).get();
	}

}
