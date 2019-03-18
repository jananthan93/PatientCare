package com.care.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.care.app.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{
	List<Patient> findPatientByCarePersonId(Integer id);
	Patient findPatientById(Integer id);
	Patient findPatientByIdAndCarePersonId(Integer id,Integer cid);
}
