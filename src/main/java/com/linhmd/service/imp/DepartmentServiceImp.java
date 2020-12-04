package com.linhmd.service.imp;

import com.linhmd.dao.core.DepartmentDAO;
import com.linhmd.dto.Department;
import com.linhmd.service.core.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Qualifier("DepSer1")
public class DepartmentServiceImp implements DepartmentService {

	@Autowired
	@Qualifier("DepSqlDAO")
	private DepartmentDAO dao;

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
