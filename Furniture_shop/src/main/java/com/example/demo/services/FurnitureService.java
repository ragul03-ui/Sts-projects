package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.orders;
import com.example.demo.repository.FurnitureRepository;

public class FurnitureService {

	@Autowired
	FurnitureRepository rep;
	public String updateEmployee(orders emp) {
		rep.save(emp);
		return "Updated";
	}
	public String updateFamily(int id) {
		rep.deleteById(id);
		return "Id deleted";
	}
}
