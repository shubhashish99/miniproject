package com.stg.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.Exception.CustomException;
import com.stg.entity.Employees;
import com.stg.repository.EmployeesRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeesRepository employeesRepository;

	@Override
	public Employees findEmployee(int employeeId, String employeeName) {
		Employees employees = employeesRepository.findByEmployeeIdAndEmployeeName(employeeId, employeeName);

		if (employees == null) {
			throw new CustomException("Employee not found!");
		} else {
			return employees;
		}
	}

	@Override
	public List<Employees> fetchEmployeesList() {

		return employeesRepository.findAll();
	}

	@Override
	public Employees addEmployee(Employees employees) {

		return employeesRepository.save(employees);
	}

	@Override
	public String updateEmployee(int employeeId, String employeeName, String employeeEmail, String employeeMobile) {

		Employees employees = employeesRepository.findByEmployeeId(employeeId);
		if (employees != null) {
			employees.setEmployeeName(employeeName);
			employees.setEmployeeEmail(employeeEmail);
			employees.setEmployeeMobile(employeeMobile);
			return "Employee details are updated!";
		} else {
			throw new CustomException("Employee not found!");
		}
	}

	@Override
	public String deleteByEmployeeId(int employeeId) {
		Employees employees = employeesRepository.findByEmployeeId(employeeId);
		if (employees != null) {
			employeesRepository.delete(employees);
			return "Employee is deleted!";
		} else {
			throw new CustomException("Employee not found!");
		}

	}

}
