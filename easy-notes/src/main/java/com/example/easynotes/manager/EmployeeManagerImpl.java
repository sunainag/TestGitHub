package com.example.easynotes.manager;

import java.util.List;

import com.example.easynotes.model.EmployeeEntity;
import com.example.easynotes.repository.EmployeeDao;

public class EmployeeManagerImpl implements EmployeeManager {
	
	private EmployeeDao employeeDao;

	@Override
	public void createEmployee(EmployeeEntity employee) {
		 employeeDao.saveEmployee(employee);
	}

	@Override
	public EmployeeEntity getEmployeeById(Long employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EmployeeEntity> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeEntity updateEmployee(Long oldEmployeeId, EmployeeEntity newEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

}
