package com.care.app.model;

public class ClientModel {
	private Integer id;
	private Integer patientId;
	
	public ClientModel(Integer id, Integer patientId) {
		super();
		this.id = id;
		this.patientId = patientId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	
}
