package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stg.entity.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

	public Employees findByEmployeeIdAndEmployeeName(int employeeId, String employeeName);

	public void deleteByEmployeeId(int employeeId);

}
