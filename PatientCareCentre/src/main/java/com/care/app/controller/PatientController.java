package com.care.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.care.app.entity.Patient;
import com.care.app.service.PatientService;

@RestController
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/Patient")
	public ResponseEntity<List<Patient>> getPatient(){
		return new ResponseEntity<> (patientService.getPatients(),HttpStatus.OK);
	}
	
	@GetMapping("/Patient/care/{cid}")
	public ResponseEntity<List<Patient>> getPatientByCarePersonId(@PathVariable Integer cid){
		return new ResponseEntity<> (patientService.getPatientByCarePersonId(cid),HttpStatus.OK);
	}
	

	@GetMapping("/Patient/{cid}/{id}")
	public ResponseEntity<Patient> getPatientByIdAndCarePersonId(@PathVariable Integer cid,@PathVariable Integer id){
		return new ResponseEntity<> (patientService.getPatientByIdAndCarePersonId(id, cid),HttpStatus.OK);
	}
	@GetMapping("/Patient/{id}")
	public Patient getById(@PathVariable Integer id) {
		return patientService.getPatientById(id);
	}
}
