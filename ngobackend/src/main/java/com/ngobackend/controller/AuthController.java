package com.ngobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngobackend.dto.JwtAuthRequest;
import com.ngobackend.dto.JwtAuthResponse;
import com.ngobackend.dto.Loggedinuser;
import com.ngobackend.security.CustomUserDetailService;
import com.ngobackend.security.jwtUtil;
import com.ngobackend.services.Userservice;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private Userservice userservice;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private jwtUtil JwtUtil;
	
	@PostMapping("/verify/{username}")
	private ResponseEntity<Boolean> verifyUsername(@PathVariable("username") String username )throws Exception
	{
		try {
			this.customUserDetailService.loadUserByUsername(username);
			return new ResponseEntity<>(true, HttpStatus.OK);
		} catch (UsernameNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		} catch(Exception e)
		{
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest jwtAuthRequest) throws Exception
	{
		try {
			this.authenticate(jwtAuthRequest.getUsername(), jwtAuthRequest.getPassword());
			UserDetails userDetails = this.customUserDetailService.loadUserByUsername(jwtAuthRequest.getUsername());
			System.out.println(userDetails);
			String token = this.JwtUtil.generateToken(userDetails);
			JwtAuthResponse res = new JwtAuthResponse();
			res.setToken(token);
			return new ResponseEntity<JwtAuthResponse>(res, HttpStatus.OK);
			
		}catch (UsernameNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (BadCredentialsException e) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	private void authenticate(String username, String password) throws Exception
	{
		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username, password);
		try {
			this.authenticationManager.authenticate(authenticationToken);
			
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new BadCredentialsException("Invalid username or password");
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception("Failed error");			
		}
		
	}

}
