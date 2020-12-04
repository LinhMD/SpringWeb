package com.linhmd.controler.rest;

import com.linhmd.dto.Department;

import com.linhmd.service.core.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/department")
public class DepartmentREST {

	@Autowired
	@Qualifier("DepSer1")
	private DepartmentService service;

	@GetMapping
	public Set<Department> getAllDepartment(){
		try {
			return service.getAllDepartment();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@GetMapping("/{id:\\d+}")
	public Department findDepartment(@PathVariable("id") int id){
		try {
			return service.findDepartmentByID(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PutMapping
	public boolean updateDepartment(@RequestBody Department department){
		try {
			System.out.println(department);
			return service.updateDepartment(department);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@DeleteMapping("/{id:\\d+}")
	public boolean deleteDepartment(@PathVariable("id") int id){
		try {
			return service.deleteDepartment(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@PostMapping
	public boolean insertDepartment(@RequestBody Department department){
		try{
			return service.insertDepartment(department);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
