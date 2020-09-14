package com.example.demo.dto;

import com.example.demo.model.Accident;

public class AccidentDTO {

	public String id;

	public String reason;

	public AccidentDTO(Accident anAccident) {
		this.setId(anAccident.getId());
		this.setReason(anAccident.getReason());
	}

	public String getId() {
		return this.id;
	}

	public void setId(String anId) {
		this.id = anId;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String aReason) {
		this.reason = aReason;
	}

}
