package com.student;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	private int id;
	private String name;
	@OneToOne
	private StudentDetail studentDetail;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StudentDetail getStudentDetail() {
		return studentDetail;
	}
	public void setStudentDetail(StudentDetail studentDetail) {
		this.studentDetail = studentDetail;
	}
	
}
