package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentDao {

	public String saveStudent(Student student);

	public Student findStudentById(Integer id);

	public String updateStudent(Student student,Integer id);

	public String deleteStudent(Integer id);
	
	public List<Student> findAll();
}
