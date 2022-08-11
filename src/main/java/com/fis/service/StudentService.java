package com.fis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.entity.Student;
import com.fis.repository.Dao;

@Service
public class StudentService {

	@Autowired
	Dao<Student> studentDaoJdbcImpl;

	public int insert(Student student) {

		return studentDaoJdbcImpl.insert(student);
	}

	public int update(Student newStudent, int id) {

		try {
			Student studentToBeUpdated = get(id);
			studentToBeUpdated.setName(newStudent.getName());
			studentToBeUpdated.setPhoneNo(newStudent.getPhoneNo());
			return studentDaoJdbcImpl.update(studentToBeUpdated);
		} catch (Exception e) {
			System.out.println("Unable to update");
		}
		return 0;
	}

	public void delete(int id) {

		Student student;
		try {
			student = get(id);
			studentDaoJdbcImpl.delete(student);
		} catch (Exception e) {
			System.out.println("Unbale to delete");
		}

	}

	public Student get(int id) {
		Student student = null;
		try {
			student = (Student) studentDaoJdbcImpl.get(id);
		} catch (Exception e) {
			System.out.println("No data with id as " + id);
		}
		return student;
	}

	public List<Student> getAll() {

		return studentDaoJdbcImpl.getAll();
	}

}
