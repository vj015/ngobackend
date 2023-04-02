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
import com.ngobackend.dto.MessageDTO;
import com.ngobackend.entities.Message;
import com.ngobackend.services.MessageService;

@Controller
@RequestMapping(path = "/message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@PostMapping("/create")
	public ResponseEntity<String> addmsg(@RequestBody MessageDTO msgDTO)
	{
		try {
			this.messageService.sendmsg(msgDTO);
			return ResponseEntity.status(HttpStatus.OK).body("Message sent Successfully!");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed!");
		
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<Message> getMessage(@PathVariable("id") Integer id)
	{
		try {
			Message u = this.messageService.getmsgByID(id);
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
	public ResponseEntity<List<Message>> getAll()
	{
		try {
			List<Message> u = this.messageService.findAllMessages();
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
	public ResponseEntity<String> deleteMessage(@PathVariable("id") Integer id)
	{
		try {
			int u = this.messageService.deleteMessage(id);
			if(u==0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Message Not Found");
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
