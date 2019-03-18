package com.care.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient {
	
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", patientName=" + patientName + ", temperature=" + temperature + ", pulseRate="
				+ pulseRate + ", carePerson=" + carePerson + "]";
	}

	private Integer id;
	private String patientName;
	private Double temperature;
	private Double pulseRate;
	
	
	private CarePerson carePerson;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getPulseRate() {
		return pulseRate;
	}

	public void setPulseRate(Double pulseRate) {
		this.pulseRate = pulseRate;
	}

	public CarePerson getCarePerson() {
		return carePerson;
	}

	public void setCarePerson(CarePerson carePerson) {
		this.carePerson = carePerson;
	}
}
