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

import com.ngobackend.entities.Event;
import com.ngobackend.services.Eventservice;

@Controller
@RequestMapping(path = "/event")
public class EventController {
	
  @Autowired	
  private Eventservice eventservice;
  
    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<String> addevent(@RequestBody Event ev)
	{
		try {
			this.eventservice.add(ev);
			return ResponseEntity.status(HttpStatus.CREATED).body("Event Created Successfully!");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed!");
		
		}
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Event> getEvent(@PathVariable("id") Integer id)
	{
		try {
			Event u = this.eventservice.findEventByID(id);
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
	
	@GetMapping("/")
	public ResponseEntity<List<Event>> getAllInterns()
	{
		try {
			List<Event> u = this.eventservice.findAllEvents();
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
			int u = this.eventservice.deleteEvent(id);
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
