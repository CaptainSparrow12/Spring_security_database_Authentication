package com.chandra.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.chandra.security.entity.Employee;
import com.chandra.security.repository.EmpRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private EmpRepository empRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Employee emp=empRepository.findByEmail(email);
		
		if(emp == null) {
			throw new UsernameNotFoundException("User name not found !!");
		}else {
			return new CustomUser(emp);
		}
	}

}
