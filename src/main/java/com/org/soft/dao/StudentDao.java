/**
 * 
 */
package com.org.soft.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.org.soft.domain.Student;
import com.org.soft.repository.StudentRepository;

/**
 * @author samy
 *
 */
@Transactional
@Repository
public class StudentDao{

	private StudentRepository studentRepository;
	
	@Autowired
	public StudentDao(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	public Student addStudent(Student student) {
		if(student != null){
			return studentRepository.save(student);
		}
		return null;
	}

	public Student getById(int id) {
		if(id != 0){
			return studentRepository.findOne(id);
		}
		return null;
	}

	public List<Student> listStudents() {
		return studentRepository.findAll();
	}

	public void deleteById(int id) {
		if(id != 0){
			studentRepository.delete(id);
		}
	}

}
