package com.ngobackend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Message")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "Contact")
	private String number;
	
	@Column(name = "Message")
	private String msg;
	
	@Column(name = "Name")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Message(int id, String number, String msg, String name) {
		super();
		this.id = id;
		this.number = number;
		this.msg = msg;
		this.name = name;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", number=" + number + ", msg=" + msg + ", name=" + name + "]";
	}


	
	
}
