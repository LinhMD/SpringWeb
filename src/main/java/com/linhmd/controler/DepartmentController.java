package com.linhmd.controler;

import com.linhmd.dao.DepartmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepartmentController {

	@Autowired
	DepartmentDAO departmentDAO;

	@RequestMapping("/department")
	public ModelAndView getAllDepartment(){
		try {
			ModelAndView mv = new ModelAndView();
			mv.addObject("departmentList", departmentDAO.getAllDepartment());
			mv.setViewName("index.jsp");
			return mv;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
