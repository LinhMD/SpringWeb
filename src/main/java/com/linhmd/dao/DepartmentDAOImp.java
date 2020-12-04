package com.linhmd.dao;

import com.linhmd.dto.Department;
import com.linhmd.utility.DBHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.stream.Collectors;

@Repository
public class DepartmentDAOImp implements DepartmentDAO {
	@Autowired
	@Qualifier("sqlConnection")
	DBHelper dbHelper;


	public Set<Department> getAllDepartment() throws Exception {
		String sql = "select id, name from department";
		Vector<Vector<String>> result = dbHelper.executeQuery(sql, new Vector<>());

		return result.size() > 0? result.stream()
				.map(Department::new)
				.collect(Collectors.toCollection(TreeSet::new)): new TreeSet<>();
	}

	@Override
	public Department findDepartmentByID(int id) throws Exception {
		String sql = "select id, name from department where id = ?";
		Vector<Object> vector = new Vector<>();
		vector.add(id);
		Vector<Vector<String>> result = dbHelper.executeQuery(sql, vector);
		if(!result.isEmpty())
			return new Department(result.get(0));
		else
			return null;
	}

	@Override
	public boolean updateDepartment(int id, Department department) throws Exception {
		String sql = "update department " +
					 "set name = ?" +
					 "where id = ?";
		Vector<Object> vector = new Vector<>();
		vector.add(department.getName());
		vector.add(id);
		return dbHelper.executeNonQuery(sql, vector);
	}

	@Override
	public boolean deleteDepartment(int id) throws Exception {
		String sql = "delete from department where id = ?";
		Vector<Object> vector = new Vector<>();
		vector.add(id);
		return dbHelper.executeNonQuery(sql, vector);
	}

	@Override
	public boolean insertDepartment(Department department) throws Exception {
		return false;
	}

	public static void main(String[] args) {
		try {
			System.out.println(new DepartmentDAOImp().getAllDepartment());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
