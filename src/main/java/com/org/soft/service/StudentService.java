/**
 * 
 */
package com.org.soft.service;

import java.util.List;

import com.org.soft.domain.Student;

/**
 * @author samy
 *
 */
public interface StudentService {

	public Student addStudent(Student student);
	public Student getById(int id);
	public List<Student> listStudents();
	public void deleteById(int id);
}
