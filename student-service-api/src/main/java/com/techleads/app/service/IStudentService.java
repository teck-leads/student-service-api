package com.techleads.app.service;

import java.util.List;

import com.techleads.app.model.Student;

public interface IStudentService {

	Student saveStudent(Student student);
	List<Student> findAllStudent();
	Student findOneStudent(Integer id);
	void deleteStudentById(Integer id);
	void updateStudentById(Student student);
	
	
}
