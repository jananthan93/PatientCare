package com.care.app.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="patient",schema="care")
public class Patient {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String patientName;
	private Double temperature;
	private Double pulseRate;
	
	@ManyToOne
	@JoinColumn(name="care_person_id")
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
