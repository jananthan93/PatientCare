package com.care.app.service;

import java.util.List;

import com.care.app.entity.CarePerson;

public interface CarePersonService {
	List<CarePerson>getPatientDetailsById(Integer Id);
}
