package com.example.demo.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.orders;
import com.example.demo.repository.FurnitureRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class FurnitureController {

	@Autowired
	private FurnitureRepository employeeRepository;
	@GetMapping("/employees")
	public List<orders> getAllEmployees(){
		return employeeRepository.findAll();
	}		
	@PostMapping("/employees")
	public orders createEmployee(@RequestBody orders employee) {
		return employeeRepository.save(employee);
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<orders> getEmployeeById(@PathVariable int id) {
		orders employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
	@PutMapping("/employees/{id}")
	public ResponseEntity<orders> updateEmployee(@PathVariable int id, @RequestBody orders employeeDetails){
		orders employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employee.setitem(employeeDetails.getitem());
		employee.setcolour(employeeDetails.getcolour());
		employee.setimg(employeeDetails.getimg());
		employee.setprice(employeeDetails.getprice());
		orders updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int id){
		orders employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}