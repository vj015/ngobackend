package com.ngobackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ngobackend.entities.User;
import com.ngobackend.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       try {
    	   long cnum = Long.parseLong(username);
    	   User op = this.userRepository.findByCnumber(cnum).orElseThrow(()->new Exception());
    	   return op;
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		System.out.println("Request is here");
		throw new UsernameNotFoundException("User name not found");
	}
		
	}

}
