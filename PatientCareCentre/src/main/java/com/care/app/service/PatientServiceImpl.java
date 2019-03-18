package com.care.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.app.entity.Patient;
import com.care.app.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<Patient> getPatientByCarePersonId(Integer id) {
		
		return patientRepository.findPatientByCarePersonId(id);
	}

	@Override
	public List<Patient> getPatients() {
		
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientByIdAndCarePersonId(Integer id, Integer cid) {
		
		return patientRepository.findPatientByIdAndCarePersonId(id, cid);
	}

	@Override
	public Patient getPatientById(Integer id) {
		
		return patientRepository.findPatientById(id);
	}

	
}
