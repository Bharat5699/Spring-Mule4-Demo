package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@Service("studentServiceBean")
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao studentDao;
	@Override
	public String saveStudent(Student student) {
		return studentDao.saveStudent(student);
		
	}

	@Override
	public Student findStudentById(Integer id) {
		return studentDao.findStudentById(id);
	}

	@Override
	public String updateStudent(Student student,Integer id) {
		return studentDao.updateStudent(student, id);
		
	}

	@Override
	public String deleteStudent(Integer id) {
		return studentDao.deleteStudent(id);
		
	}

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

}
