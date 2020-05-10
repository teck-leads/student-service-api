package com.techleads.app.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techleads.app.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
