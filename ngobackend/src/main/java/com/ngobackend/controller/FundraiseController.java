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

import com.ngobackend.dto.donatefundraiseDTO;
import com.ngobackend.dto.fundraiseDTO;
import com.ngobackend.entities.fundraise;
import com.ngobackend.services.FundraiseService;

@Controller
@RequestMapping(path = "/raisefunds")
public class FundraiseController {
	
	@Autowired
	private FundraiseService fundraiseService;
	
    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<String> addevent(@RequestBody fundraiseDTO fd)
	{
		try {
			this.fundraiseService.addFundraise(fd);
			return ResponseEntity.status(HttpStatus.CREATED).body("Fundraise Created Successfully!");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed!");
		
		}
	}
    
    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/update/{id}")
	public ResponseEntity<String> updateevent(@PathVariable("id") Integer id, @RequestBody fundraiseDTO fd)
	{
		try {
			int ans = this.fundraiseService.editFundraise(fd, id);
			if(ans==0)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
			}
			else {
			return ResponseEntity.status(HttpStatus.OK).body("Fundraise updated Successfully!");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed!");
		
		}
	}
    
	@GetMapping("/like/{id}/{isadd}")
	public ResponseEntity<Integer> likefundraise(@PathVariable("id") Integer id, @PathVariable("isadd") Boolean isadd)
	{
		try {
			int a = this.fundraiseService.like(id, isadd);
			if(a==-1) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
				}
			else {
				return ResponseEntity.status(HttpStatus.OK).body(a);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		
		}
	}
	
	@GetMapping("/getdays/{id}")
	public ResponseEntity<Integer> daysinfundraise(@PathVariable("id") Integer id)
	{
		try {
			int a = this.fundraiseService.getDays(id);
			if(a==-1) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
				}
			else {
				return ResponseEntity.status(HttpStatus.OK).body(a);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		
		}
	}
    
	@GetMapping("/{id}")
	public ResponseEntity<fundraise> getFundraise(@PathVariable("id") Integer id)
	{
		try {
			fundraise u = this.fundraiseService.findfundraiseByID(id);
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
	public ResponseEntity<List<fundraise>> getAllInterns()
	{
		try {
			List<fundraise> u = this.fundraiseService.findAllfundraise();
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
	public ResponseEntity<String> deleteFundraise(@PathVariable("id") Integer id)
	{
		try {
			int u = this.fundraiseService.deletefundraise(id);
			if(u==0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("fundraise Not Found");
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
	
	@PostMapping("/donate")
	public ResponseEntity<String> makeFundraise(@RequestBody donatefundraiseDTO fd)
	{
		try {
			int u = this.fundraiseService.increasecurrentamount(fd.getAmt(), fd.getId());
			if(u==0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("fundraise is completed");
				}
			else {
				return ResponseEntity.status(HttpStatus.OK).body("Done");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error!");
		
		}
	}
    
    

}
