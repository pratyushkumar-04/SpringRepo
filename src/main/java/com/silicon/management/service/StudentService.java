package com.silicon.management.service;

import java.util.List;

import com.silicon.management.model.Student;

public interface StudentService {

	/**
	 * @param st
	 */
	public void addStudent(Student st);
	
	/**
	 * returns the list of students
	 * @return
	 */
	public List<Student> fetchStudent();
	
	public void updateStudent(Student st);
	
	public void deleteStudent(Long id);
}
