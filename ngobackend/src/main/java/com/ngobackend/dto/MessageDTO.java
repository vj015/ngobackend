package com.ngobackend.dto;

public class MessageDTO {

	private int id;
	private String number;
	private String msg;
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
	
	public MessageDTO(int id, String number, String msg, String name) {
		super();
		this.id = id;
		this.number = number;
		this.msg = msg;
		this.name = name;
	}
	public MessageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MessageDTO [id=" + id + ", number=" + number + ", msg=" + msg + ", name=" + name + "]";
	}
	
	
	
	
}
