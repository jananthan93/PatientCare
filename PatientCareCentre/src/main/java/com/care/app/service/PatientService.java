package com.care.app.service;

import java.util.List;

import com.care.app.entity.Patient;

public interface PatientService {
	List<Patient>getPatientByCarePersonId(Integer id);
	List<Patient>getPatients();
	Patient getPatientByIdAndCarePersonId(Integer id,Integer cid);
	Patient getPatientById(Integer id);
}
