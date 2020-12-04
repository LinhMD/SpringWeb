package com.linhmd.controler;

import com.linhmd.dao.DepartmentDAO;
import com.linhmd.dto.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentDAO departmentDAO;

	@RequestMapping("/all")
	public Set<Department> getAllDepartment(){
		try {
			return departmentDAO.getAllDepartment();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
