package com.linhmd.service;

import com.linhmd.dao.DepartmentDAO;
import com.linhmd.dto.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Set;

public class DepartmentServiceImp implements DepartmentService {

	@Autowired
	@Qualifier("DepSqlDAO")
	DepartmentDAO dao;

	@Override
	public Set<Department> getAllDepartment() throws Exception {
		return dao.getAllDepartment();
	}

	@Override
	public Department findDepartmentByID(int id) throws Exception {
		return dao.findDepartmentByID(id);
	}

	@Override
	public boolean updateDepartment(Department department) throws Exception {
		return dao.updateDepartment(department);
	}

	@Override
	public boolean deleteDepartment(int id) throws Exception {
		return false;
	}

	@Override
	public boolean insertDepartment(Department department) throws Exception {
		return false;
	}
}
