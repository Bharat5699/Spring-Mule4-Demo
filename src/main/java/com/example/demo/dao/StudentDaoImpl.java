package com.example.demo.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;


@Repository("studentDaoBean")
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public String saveStudent(Student student) {
		String res="";
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try {
				session.save(student);
				session.flush();
				tx.commit();
				res="Data Save Sucessfully";
		}catch (Exception e) {
			tx.rollback();
		}
		finally {
			session.close();
		}
		return res;
	}

	@Override
	public Student findStudentById(Integer id) {
		Student student=null;
		Session session=sessionFactory.openSession();
		try {
		student= (Student) session.get(Student.class, id);
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		
		return student;
	}

	@Override
	public String updateStudent(Student student,Integer id) {
		String res="";
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try {
			Student oldStudent=(Student) session.get(Student.class, id);
			oldStudent.setFirstName(student.getFirstName());
			oldStudent.setMiddleName(student.getMiddleName());
			oldStudent.setLastName(student.getLastName());
				session.update(oldStudent);
				session.flush();
				tx.commit();
				res="Data update Successfully";
		}catch (Exception e) {
			tx.rollback();
		}
		finally {
			session.close();
		}
		return res;
	}

	@Override
	public String deleteStudent(Integer id) {
		String res="";
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try {
				
			Query query=session.createQuery("Delete From Student where id=:id");
			query.setParameter("id", id);
			int count=query.executeUpdate();
			session.flush();
			tx.commit();
			if(count>0)
				res="Data Deleted Successfully";
		}catch (Exception e) {
			tx.rollback();
		}
		finally {
			session.close();
		}
		return res;
	}

	@Override
	public List<Student> findAll() {
		
		List<Student> studentList=null;
		Session session=sessionFactory.openSession();
		try {
			Query qry=session.createQuery("from Student");
			studentList= qry.list();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		
		return studentList;
	}
	
	

}
