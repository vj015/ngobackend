package com.ngobackend.dto;

public class donatefundraiseDTO {
	
	private int id;
	
	private long amt;

	public donatefundraiseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public donatefundraiseDTO(int id, long amt) {
		super();
		this.id = id;
		this.amt = amt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getAmt() {
		return amt;
	}

	public void setAmt(long amt) {
		this.amt = amt;
	}

	@Override
	public String toString() {
		return "donatefundraiseDTO [id=" + id + ", amt=" + amt + "]";
	}
	
	

}
