package com.ngobackend.dto;


public class fundraiseDTO {

	public fundraiseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	private int id;
	private String title;
	private String message;
	private String startDate;
	private String endDate;
	private long currentamount;
	private long totalamount;
	private int likes;
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

	public long getCurrentamount() {
		return currentamount;
	}

	public void setCurrentamount(long currentamount) {
		this.currentamount = currentamount;
	}

	public long getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(long totalamount) {
		this.totalamount = totalamount;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
	

	public fundraiseDTO(int id, String title, String message, String startDate, String endDate, long currentamount,
			long totalamount, int likes) {
		super();
		this.id = id;
		this.title = title;
		this.message = message;
		this.startDate = startDate;
		this.endDate = endDate;
		this.currentamount = currentamount;
		this.totalamount = totalamount;
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "fundraiseDTO [id=" + id + ", title=" + title + ", message=" + message + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", currentamount=" + currentamount + ", totalamount=" + totalamount
				+ ", likes=" + likes + "]";
	}


	
	
	
}
