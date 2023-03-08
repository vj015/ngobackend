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

import com.ngobackend.dto.InternDTO;
import com.ngobackend.entities.Intern;
import com.ngobackend.services.Internservice;

@Controller
@RequestMapping(path = "/intern")
public class InternController {
	
	@Autowired
	private Internservice internservice;
	
	@PostMapping("/create")
	public ResponseEntity<String> addintern(@RequestBody InternDTO internDTO)
	{
		try {
			this.internservice.add(internDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body("Intern Created Successfully!");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed!");
		
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/select/{id}/{isnotify}")
	public ResponseEntity<String> updateselect(@PathVariable("id") Integer id ,@PathVariable("isnotify") Boolean isnotify)
	{
		try {
			int a = this.internservice.updateSelected(id, isnotify);
			if(a==1) {
			return ResponseEntity.status(HttpStatus.OK).body("Intern updated Successfully!");
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Intern does not exists");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed!");
		
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<Intern> getIntern(@PathVariable("id") Integer id)
	{
		try {
			Intern u = this.internservice.findInternByID(id);
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
	public ResponseEntity<List<Intern>> getAllInterns()
	{
		try {
			List<Intern> u = this.internservice.findAllInterns();
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
			int u = this.internservice.deleteIntern(id);
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
