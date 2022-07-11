package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {

	
	public String saveStudent(Student student);

	public Student findStudentById(Integer id);

	public String updateStudent(Student student,Integer id);

	public String deleteStudent(Integer id);
	
	public List<Student> findAll();
	
}
