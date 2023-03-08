package com.ngobackend.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ngobackend.dto.UserDTO;
import com.ngobackend.entities.Role;
import com.ngobackend.entities.User;
import com.ngobackend.repository.RoleRepository;
import com.ngobackend.repository.UserRepository;

@Service
public class Userservice {
	
	@Autowired
	private PasswordEncoder passwordEncoder;	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public void addUser(UserDTO userDTO) throws Exception
	{
		try {
			User user = convertuser(userDTO);
			user.setPassword(this.passwordEncoder.encode(user.getPassword()));
			Optional<Role> opt = this.roleRepository.findById(2);
			Set<Role> s = new HashSet<Role>();
			s.add(opt.get());
			user.setRole(s);
			this.userRepository.save(user);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception();
		}

	}
	
	public int updateUser(UserDTO u1, int id, boolean notify) throws Exception
	{
		try {
			Optional<User> optional=this.userRepository.findById(id);
			if(optional.isPresent())
			{
				User u = optional.get();
				u.setAddress(u1.getAddress());
				u.setCity(u1.getCity());
				u.setCnumber(u1.getCnumber());
				u.setDob(u1.getDob());
				u.setGender(u1.getGender());
				u.setName(u1.getName());
				u.setNotify(notify);
				u.setPassword(u1.getPassword());
				u.setWnumber(u1.getWnumber());
				this.userRepository.save(u);
				return 1;
			}
			else {
				return 0;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public User findUserByID(int id) throws Exception
	{
		try {
			Optional<User> optional=this.userRepository.findById(id);
			if(optional.isPresent())
			{
				return optional.get();
			}
			else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public List<User> findAllUsers() throws Exception
	{
		try {
			List<User> u = this.userRepository.findAll();
			if(u.isEmpty())
			{
				return null;
			}
			else {
				return u;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception();
		}
		
	}
	
	public int deleteUser(int id) throws Exception
	{
		try {
			Optional<User> optional=this.userRepository.findById(id);
			if(optional.isPresent())
			{
				User u = optional.get();
				u.setRole(null);
				this.userRepository.delete(u);
				return 1;
			}else {
				return 0;
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public int updateNotify(int id, boolean flag) throws Exception
	{
		try {
			Optional<User> optional=this.userRepository.findById(id);
			if(optional.isPresent())
			{
				User u = optional.get();
				u.setNotify(flag);
				this.userRepository.save(u);
				return 1;
			}else {
				return 0;
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	User convertuser(UserDTO u1)
	{
		User u = new User();
		u.setAddress(u1.getAddress());
		u.setCity(u1.getCity());
		u.setCnumber(u1.getCnumber());
		u.setDob(u1.getDob());
		u.setGender(u1.getGender());
		u.setName(u1.getName());
		u.setNotify(false);
		u.setPassword(u1.getPassword());
		u.setWnumber(u1.getWnumber());
		
		return u;
		
	}

}
