package com.example.demo.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;

public class Accident {

	@Id
	public String id;

	public Date date;

	public String reason;

	public Accident(@Value("date") Date aDate, @Value("reason") String aReason) {
		this.setDate(aDate);
		this.setReason(aReason);
	}

	public String getId() {
		return this.id;
	}

	public void setId(String anId) {
		this.id = anId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date aDate) {
		this.date = aDate;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String aReason) {
		this.reason = aReason;
	}

}
