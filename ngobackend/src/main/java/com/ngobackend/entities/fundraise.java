package com.ngobackend.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fundraising")
public class fundraise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "current amount")
	private long currentamount;
	
	@Column(name = "total amount")
	private long totalmount;
	
	@Column(name = "Start Date")
	private String startDate;
	
	@Column(name = "End Date")
	private String endDate;
	
	@Column(name = "likes")
	private int likes;

	public fundraise() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	




	public fundraise(int id, String title, String message, long currentamount, long totalmount, String startDate,
			String endDate, int likes) {
		super();
		this.id = id;
		this.title = title;
		this.message = message;
		this.currentamount = currentamount;
		this.totalmount = totalmount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.likes = likes;
	}






	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getCurrentamount() {
		return currentamount;
	}

	public void setCurrentamount(long currentamount) {
		this.currentamount = currentamount;
	}

	public long getTotalmount() {
		return totalmount;
	}

	public void setTotalmount(long totalmount) {
		this.totalmount = totalmount;
	}
	

	public String getStartDate() {
		return startDate;
	}



	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}



	public String getEndDate() {
		return endDate;
	}



	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}



	public int getLikes() {
		return likes;
	}






	public void setLikes(int likes) {
		this.likes = likes;
	}






	@Override
	public String toString() {
		return "fundraise [id=" + id + ", title=" + title + ", message=" + message + ", currentamount=" + currentamount
				+ ", totalmount=" + totalmount + ", startDate=" + startDate + ", endDate=" + endDate + ", likes="
				+ likes + "]";
	}







	
	
	
	
	
	
	

}
