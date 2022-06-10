package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.stg.Services.EmployeeService;
import com.stg.entity.Employees;

@RestController
@RequestMapping(value = "employee")
@CrossOrigin("http://localhost:4200/")
public class EmployeesController {

	@Autowired
	private EmployeeService employeesService;

	@GetMapping(value = "/findEmployee/{employeeId}/{employeeName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employees> findEmployee(@PathVariable int employeeId, @PathVariable String employeeName) {

		Employees employees = employeesService.findEmployee(employeeId, employeeName);

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

	@PutMapping(value = "/updateEmployee/{employeeId}/{employeeName}/{employeeEmail}/{employeeMobile}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateEmployee(@PathVariable int employeeId, @PathVariable String employeeName,
			@PathVariable String employeeEmail, @PathVariable String employeeMobile) {

		String employees1 = employeesService.updateEmployee(employeeId, employeeName, employeeEmail, employeeMobile);

		return new ResponseEntity<String>(employees1, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteByEmployeeId/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteByEmployeeId(@PathVariable int employeeId) {

		String employee = employeesService.deleteByEmployeeId(employeeId);

		return new ResponseEntity<String>(employee, HttpStatus.OK);
	}

}
