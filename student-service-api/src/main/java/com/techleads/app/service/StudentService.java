package com.techleads.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techleads.app.model.Student;
import com.techleads.app.respository.StudentRepository;

@Service
public class StudentService implements IStudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		student = studentRepository.save(student);
		return student;
	}

	@Override
	public List<Student> findAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student findOneStudent(Integer id) {
		if(studentRepository.existsById(id)) {
			return studentRepository.findById(id).get();
		}else {
			return new Student();
		}
		
	}

	@Override
	public void deleteStudentById(Integer id) {
		studentRepository.deleteById(id);

	}

	@Override
	public void updateStudentById(Student student) {
		studentRepository.save(student);

	}

}
