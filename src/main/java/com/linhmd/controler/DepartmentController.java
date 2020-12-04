package com.linhmd.controler;

import com.linhmd.dao.DepartmentDAO;
import com.linhmd.dto.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentDAO departmentDAO;

	@GetMapping
	public Set<Department> getAllDepartment(){
		try {
			return departmentDAO.getAllDepartment();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@GetMapping("/{id:\\d+}")
	public Department findDepartment(@PathVariable("id") int id){
		try {
			return departmentDAO.findDepartmentByID(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PutMapping
	public boolean updateDepartment(@RequestBody Department department){
		try {
			return departmentDAO.updateDepartment(department.getId(), department);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@DeleteMapping("/{id:\\d+}")
	public boolean deleteDepartment(@PathVariable("id") int id){
		try {
			return departmentDAO.deleteDepartment(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@PostMapping
	public boolean insertDepartment(@RequestBody Department department){
		try{
			System.out.println(department);
			return departmentDAO.insertDepartment(department);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}
}
