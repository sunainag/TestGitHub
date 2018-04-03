package com.example.easynotes.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.easynotes.model.EmployeeEntity;

public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
    private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEmployee(EmployeeEntity note) {
		getSession().saveOrUpdate(note);
	}

	@Override
	public EmployeeEntity getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(EmployeeEntity employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
