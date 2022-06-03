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
	public Employees checkCEmployee(int employeeId, String employeeName) {
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
	public List<Employees> searchByIdAndEmpName(int employeeId, String employeeName) {

		return (List<Employees>) employeesRepository.findByEmployeeIdAndEmployeeName(employeeId, employeeName);
	}

	@Override
	public Employees updateEmployee(Employees employees) {

		return employeesRepository.save(employees);
	}

	@Override
	public void deleteByEmployeeId(int employeeId) {
		employeesRepository.deleteByEmployeeId(employeeId);

	}

}
