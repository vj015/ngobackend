package com.ngobackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngobackend.entities.Event;
import com.ngobackend.repository.EventRepository;

@Service
public class Eventservice {
	
	@Autowired
	private EventRepository eventRepository;
	
	public void add(Event ev) throws Exception
	{
		try {
			this.eventRepository.save(ev);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public Event findEventByID(int id) throws Exception
	{
		try {
			Optional<Event> optional=this.eventRepository.findById(id);
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
	
	public List<Event> findAllEvents() throws Exception
	{
		try {
			List<Event> u = this.eventRepository.findAll();
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
	
	public int deleteEvent(int id) throws Exception
	{
		try {
			Optional<Event> optional=this.eventRepository.findById(id);
			if(optional.isPresent())
			{
				Event u = optional.get();
				this.eventRepository.delete(u);
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
	

}
