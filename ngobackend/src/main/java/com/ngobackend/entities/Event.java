package com.ngobackend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Events")
public class Event {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name = "Content")
	String content;
	
	@Column(name = "Day of Event")
	String dayofEvent;



	public Event(int id, String content, String dayofEvent) {
		super();
		this.id = id;
		this.content = content;
		this.dayofEvent = dayofEvent;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

	public String getDayofEvent() {
		return dayofEvent;
	}

	public void setDayofEvent(String dayofEvent) {
		this.dayofEvent = dayofEvent;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", content=" + content + ", dayofEvent=" + dayofEvent + "]";
	}



	
}
