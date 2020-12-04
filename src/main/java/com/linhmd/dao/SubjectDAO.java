package com.linhmd.dao;

import com.linhmd.dto.Subject;

import java.util.Set;

public interface SubjectDAO {
	/* return all department available in database if not return empty list */
	Set<Subject> getAllSubject() throws Exception;
	/* find Subject by it id if not found return null */
	Subject findSubjectByID(int id) throws Exception;
	/* update a Subject by id take a new Subject to update */
	boolean updateSubject(int id, Subject subject) throws Exception;
	/*delete Subject by it id*/
	boolean deleteSubject(int id) throws Exception;
	/*insert a new Subject*/
	boolean insertSubject(Subject subject) throws Exception;
}
