package com.stg.Services;

import java.util.List;

import com.stg.entity.Employees;

public interface EmployeeService {

	public abstract Employees findEmployee(int employeeId, String employeeName); // validation

	public abstract List<Employees> fetchEmployeesList(); // read

	public abstract Employees addEmployee(Employees employees); // add

	public abstract String updateEmployee(int employeeId, String employeeName, String employeeEmail,
			String employeeMobile); // update

	public abstract String deleteByEmployeeId(int employeeId); // delete

}