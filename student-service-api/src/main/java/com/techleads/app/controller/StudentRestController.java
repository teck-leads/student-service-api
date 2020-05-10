package com.techleads.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.model.Student;
import com.techleads.app.service.IStudentService;

@RestController
public class StudentRestController {
	@Autowired
	private HttpHeaders responseHeaders;

	@Autowired
	private IStudentService iStudentService;

	@GetMapping(value = {"/students"})
	public ResponseEntity<List<Student>> findAllStudents() {
		try {
			responseHeaders.set("GET_ALL", "200");
			List<Student> findAllStudent = iStudentService.findAllStudent();
			return new ResponseEntity<List<Student>>(findAllStudent, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping(value = {"/students/{id}"})
	public ResponseEntity<Student> findStudentsById(@PathVariable("id") Integer id) {
		try {
			responseHeaders.set("GET_ID", "200");
			 Student findOneStudent = iStudentService.findOneStudent(id);
			return new ResponseEntity<Student>(findOneStudent, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PostMapping(value = {"/students"})
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		try {
			responseHeaders.set("SAVE", "201");
			 Student findOneStudent = iStudentService.saveStudent(student);
			return new ResponseEntity<Student>(findOneStudent, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PutMapping(value = {"/students"})
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		try {
			responseHeaders.set("UPDATE", "200");
			 Student findOneStudent = iStudentService.saveStudent(student);
			return new ResponseEntity<Student>(findOneStudent, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@DeleteMapping(value = {"/students/{id}"})
	public ResponseEntity<List<Student>> deleteStudentById(@PathVariable("id") Integer id) {
		try {
			responseHeaders.set("DELETE", "200");
			iStudentService.deleteStudentById(id);
			List<Student> findAllStudent = iStudentService.findAllStudent();
			return new ResponseEntity<List<Student>>(findAllStudent, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}


}
