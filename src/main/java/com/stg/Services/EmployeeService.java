package com.stg.Services;

import java.util.List;

import com.stg.entity.Employees;

public interface EmployeeService {

	public abstract Employees checkCEmployee(int employeeId, String employeeName); // validation

	public abstract List<Employees> fetchEmployeesList(); // read

	public abstract Employees addEmployee(Employees employees); // add

	public abstract List<Employees> searchByIdAndEmpName(int employeeId, String employeeName); // search

	public abstract Employees updateEmployee(Employees employees); // update

	public abstract void deleteByEmployeeId(int employeeId); // delete

}