package com.example.easynotes.repository;

import java.util.List;
import com.example.easynotes.model.EmployeeEntity;

public interface EmployeeDao {
	
	public List<EmployeeEntity> getAllEmployees();

	public EmployeeEntity getEmployeeById(Long id);

	public void saveEmployee(EmployeeEntity employee);

	public void deleteEmployee(EmployeeEntity employee);

	public EmployeeEntity updateEmployee(EmployeeEntity employee);

}
