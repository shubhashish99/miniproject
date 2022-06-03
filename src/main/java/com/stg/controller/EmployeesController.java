package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.Services.EmployeeService;
import com.stg.entity.Employees;

@RestController
public class EmployeesController {

	@Autowired
	private EmployeeService employeesService;

	@GetMapping(value = "/checkEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employees> checkEmployee(@RequestBody int employeeId, @RequestParam String employeeName) {

		Employees employees = employeesService.checkCEmployee(employeeId, employeeName);

		return new ResponseEntity<Employees>(employees, HttpStatus.OK);
	}

	@GetMapping(value = "/fetchEmployeesList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employees> fetchEmployeesList() {

		List<Employees> employees = employeesService.fetchEmployeesList();

		return new ResponseEntity<Employees>((Employees) employees, HttpStatus.OK);
	}

	@PostMapping(value = "/addEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employees> addEmployee(@RequestBody Employees employees) {

		Employees employees1 = employeesService.addEmployee(employees);

		return new ResponseEntity<Employees>(employees1, HttpStatus.OK);
	}

	@GetMapping(value = "/searchByIdAndEmpName", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employees> searchByIdAndEmpName(@RequestBody int employeeId,
			@RequestParam String employeeName) {

		List<Employees> employees = employeesService.searchByIdAndEmpName(employeeId, employeeName);

		return new ResponseEntity<Employees>((Employees) employees, HttpStatus.OK);
	}

	@PutMapping(value = "/updateEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employees> updateEmployee(@RequestBody Employees employees) {

		Employees employees1 = employeesService.updateEmployee(employees);

		return new ResponseEntity<Employees>(employees1, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteByEmployeeId", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employees> deleteByEmployeeId(@RequestBody int employeeId) {

		employeesService.deleteByEmployeeId(employeeId);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
