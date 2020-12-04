package com.linhmd.service.core;

import com.linhmd.dto.Department;

import java.util.Set;

public interface DepartmentService {
	Set<Department> getAllDepartment() throws Exception;
	Department findDepartmentByID(int id) throws Exception;
	boolean updateDepartment(Department department) throws Exception;
	boolean deleteDepartment(int id) throws Exception;
	boolean insertDepartment(Department department) throws Exception;
}
