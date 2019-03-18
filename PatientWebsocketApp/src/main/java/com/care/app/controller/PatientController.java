package com.care.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.care.app.model.ClientModel;
import com.care.app.model.Patient;

@RestController
public class PatientController {

	@MessageMapping("/hellocare")
	@SendTo("/sendtopic/patient")
	public Patient[] getPatients(RestTemplate restTemplate) {
			Patient[] patients = restTemplate.getForObject(
					"http://localhost:8005/Patient", Patient[].class);
			 return patients;
		}

	@MessageMapping("/helloPerson")
	@SendTo("/sendtopic/person")
	public Patient[] getPatientByCarePersonId(RestTemplate restTemplate,@RequestBody ClientModel clientModel) {
		Integer cid = clientModel.getId();
		Patient[] patients = restTemplate.getForObject(
				"http://localhost:8005/Patient/care/{cid}", Patient[].class,cid);
		 return patients;
	}
	
	Integer cId,pId=null;
	Patient patient=new Patient();
	@MessageMapping("/helloOneperson")
	public void getObject(ClientModel client) {
		cId=client.getId();
		pId=client.getPatientId();
		ClientModel clientModel = new ClientModel(cId,pId);
		RestTemplate restTemplate=new RestTemplate();
		patient = restTemplate.getForObject(
				"http://localhost:8005/Patient/{cid}/{pid}", Patient.class,clientModel.getId(),clientModel.getPatientId());
	}

	ArrayList<Patient> clientPatient = new ArrayList<>();
	public List<Patient> getClientPatient(){
		clientPatient.add(patient);
		return clientPatient;
	}
	
	@EnableScheduling
	@Configuration
	@Controller
	public class SchedulerConfig {
		
		@Autowired
		SimpMessagingTemplate template;
//		
		@Scheduled(fixedDelay=3000)
		public void getSchedulePatient(){
//			for(int i=0;i<clientPatient.size();i++) {
//				template.convertAndSend("/sendtopic/Onepatient",clientPatient.get(i));
//			}
			template.convertAndSend("/sendtopic/Onepatient",patient);
//			log.info(patient.toString());
		}
	}
	
//	@MessageMapping("/helloOneperson")
//	@SendTo("/sendtopic/Onepatient")
//	public Patient getPatientByCarePersonIdAndPatientId(RestTemplate restTemplate,@RequestBody ClientModel clientModel) {
//		Integer cId = clientModel.getId();
//		Integer pId = clientModel.getPatientId();
//		Patient patient = restTemplate.getForObject(
//				"http://localhost:8005/Patient/{cid}/{pid}", Patient.class,cId,pId);
//		 return patient;
//		
//	}


}
