package com.ngobackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngobackend.dto.InternDTO;
import com.ngobackend.entities.Intern;
import com.ngobackend.repository.InternRepository;

@Service
public class Internservice {
	
	@Autowired
	private InternRepository internRepository;
	
	public void add(InternDTO i) throws Exception
	{
		try {
			Intern in = convertIntern(i);
			this.internRepository.save(in);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public Intern findInternByID(int id) throws Exception
	{
		try {
			Optional<Intern> optional=this.internRepository.findById(id);
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
	
	public List<Intern> findAllInterns() throws Exception
	{
		try {
			List<Intern> u = this.internRepository.findAll();
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
	
	public int deleteIntern(int id) throws Exception
	{
		try {
			Optional<Intern> optional=this.internRepository.findById(id);
			if(optional.isPresent())
			{
				Intern u = optional.get();
				this.internRepository.delete(u);
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
	
	public int updateSelected(int id, boolean flag) throws Exception
	{
		try {
			Optional<Intern> optional=this.internRepository.findById(id);
			if(optional.isPresent())
			{
				Intern u = optional.get();
				u.setSelected(flag);
				this.internRepository.save(u);
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
	
	Intern convertIntern(InternDTO i)
	{
		Intern i1=new Intern();
		i1.setAddress(i.getAddress());
		i1.setCity(i.getCity());
		i1.setCnumber(i.getCnumber());
		i1.setCollege(i.getCollege());
		i1.setDob(i.getDob());
		i1.setEducation(i.getEducation());
		i1.setEmail(i.getEmail());
		i1.setExpertise(i.getExpertise());
		i1.setGender(i.getGender());
		i1.setName(i.getName());
		i1.setPincode(i.getPincode());
		i1.setReason(i.getReason());
		i1.setSelected(false);
		i1.setState(i.getState());
		i1.setWnumber(i.getWnumber());
		return i1;
		
	}

}
