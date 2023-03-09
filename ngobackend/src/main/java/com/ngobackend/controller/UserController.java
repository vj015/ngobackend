package com.ngobackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ngobackend.dto.Loggedinuser;
import com.ngobackend.dto.UserDTO;
import com.ngobackend.entities.User;
import com.ngobackend.services.Userservice;

@Controller
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	private Userservice userservice;
	
	@PostMapping("/create")
	public ResponseEntity<String> adduser(@RequestBody UserDTO userDTO)
	{
		try {
			this.userservice.addUser(userDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully!");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed!");
		
		}
	}
	
	@GetMapping("/loggedinuser")
	public ResponseEntity<Loggedinuser> getloggeduser()
	{
		try {
			Loggedinuser ans = this.userservice.getloggedinuserinfo();
			return ResponseEntity.status(HttpStatus.OK).body(ans);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		
		}
	}
	
	@PostMapping("/update/{id}/{isnotify}")
	public ResponseEntity<String> updateuser(@PathVariable("id") Integer id ,@PathVariable("isnotify") Boolean isnotify,@RequestBody UserDTO userDTO)
	{
		try {
			int a = this.userservice.updateUser(userDTO, id, isnotify);
			if(a==1) {
			return ResponseEntity.status(HttpStatus.OK).body("User updated Successfully!");
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exists");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed!");
		
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/updateNotification/{id}/{isnotify}")
	public ResponseEntity<String> updatenotifyuser(@PathVariable("id") Integer id ,@PathVariable("isnotify") Boolean isnotify)
	{
		try {
			int a = this.userservice.updateNotify(id, isnotify);
			if(a==1) {
			return ResponseEntity.status(HttpStatus.OK).body("User updated Successfully!");
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exists");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed!");
		
		}
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Integer id)
	{
		try {
			User u = this.userservice.findUserByID(id);
			if(u==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
				}
			else {
				return ResponseEntity.status(HttpStatus.OK).body(u);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUser()
	{
		try {
			List<User> u = this.userservice.findAllUsers();
			if(u==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
				}
			else {
				return ResponseEntity.status(HttpStatus.OK).body(u);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id)
	{
		try {
			int u = this.userservice.deleteUser(id);
			if(u==0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
				}
			else {
				return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error!");
		
		}
	}

}
