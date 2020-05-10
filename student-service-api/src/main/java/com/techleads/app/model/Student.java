package com.techleads.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="student_table")
public class Student {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Double fees;
	private String course;

}
