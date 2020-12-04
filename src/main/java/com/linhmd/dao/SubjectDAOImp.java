package com.linhmd.dao;

import com.linhmd.dto.Subject;
import com.linhmd.utility.DBHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

public class SubjectDAOImp implements SubjectDAO{
	@Autowired
	DBHelper dbHelper;

	@Override
	public Set<Subject> getAllSubject() throws Exception {
		String sql = "select s.code, d.name as 'department', s.name_VN, s.name_EN, s.short_name, s.term, s.is_extra\n" +
				"from subject s left join department d\n" +
				"on s.department_code = d.id";
		return dbHelper.executeQuery(sql, new Vector<>())
				.stream()
				.map(Subject::new)
				.collect(Collectors.toSet());
	}

	@Override
	public Subject findSubjectByID(int id) throws Exception {
		String sql = "select s.code, d.name as 'department', s.name_VN, s.name_EN, s.short_name, s.term, s.is_extra\n" +
				"from subject s left join department d\n" +
				"on s.department_code = d.id\n" +
				"where s.code = ?";
		Vector<Vector<String>> vectors = dbHelper.executeQuery(sql, new Vector<>());
		return vectors.size() > 0? new Subject(vectors.get(0)): null;
	}

	@Override
	public boolean updateSubject(int id, Subject subject) throws Exception {
		return false;
	}

	@Override
	public boolean deleteSubject(int id) throws Exception {
		String sql = "delete from subject where code = ?";
		Vector<Object> vector = new Vector<>();
		vector.add(id +"");
		return dbHelper.executeNonQuery(sql, vector);
	}

	@Override
	public boolean insertSubject(Subject subject) throws Exception {
		String sql = "insert into subject (code, department_code, name_VN, name_EN, short_name, term, is_extra)\n" +
				"values(?, ?, ?, ?, ?, ?, ?)";
		Vector<Object> vector = new Vector<>();
		vector.add(subject.getCode());
		vector.add(subject.getDepartment());
		vector.add(subject.getNameVN());
		vector.add(subject.getNameEN());
		vector.add(subject.getNameShort());
		vector.add(subject.getTerm());
		vector.add(subject.isExtra());
		return dbHelper.executeNonQuery(sql, vector);
	}
}
