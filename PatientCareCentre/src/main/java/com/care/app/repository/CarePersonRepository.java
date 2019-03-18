package com.care.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.care.app.entity.CarePerson;

public interface CarePersonRepository extends JpaRepository<CarePerson, Integer>{
	
}
