package com.example.easynotes.manager;

import java.util.List;
import com.example.easynotes.model.EmployeeEntity;

public interface EmployeeManager {

	void createEmployee(EmployeeEntity employee);

	EmployeeEntity getEmployeeById(Long employeeId);

	void deleteEmployee(Long employeeId);

	List<EmployeeEntity> getEmployees();
	
	EmployeeEntity updateEmployee(Long oldEmployeeId, EmployeeEntity newEmployee);
}
