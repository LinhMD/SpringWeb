package com.linhmd.dao;

import com.linhmd.dto.Department;

import java.util.List;
import java.util.Set;

public interface DepartmentDAO {
	/* return all department available in database if not return empty list */
	Set<Department> getAllDepartment() throws Exception;
	/* find department by it id if not found return null */
	Department findDepartmentByID(int id) throws Exception;
	/* update a department by id take a new department to update */
	boolean updateDepartment(Department department) throws Exception;
	/*delete department by it id*/
	boolean deleteDepartment(int id) throws Exception;
	/*insert a new department*/
	boolean insertDepartment(Department department) throws Exception;
}
