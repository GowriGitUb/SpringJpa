/**
 * 
 */
package com.org.soft.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.soft.dao.StudentDao;
import com.org.soft.domain.Student;
import com.org.soft.service.StudentService;

/**
 * @author samy
 *
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	
	@Autowired
	public StudentServiceImpl(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}

	/* (non-Javadoc)
	 * @see com.org.soft.service.StudentService#addStudent(com.org.soft.domain.Student)
	 */
	public Student addStudent(Student student) {
		return studentDao.addStudent(student);
	}

	/* (non-Javadoc)
	 * @see com.org.soft.service.StudentService#getById(java.lang.String)
	 */
	public Student getById(int id) {
		return studentDao.getById(id);
	}

	/* (non-Javadoc)
	 * @see com.org.soft.service.StudentService#listStudents()
	 */
	public List<Student> listStudents() {
		return studentDao.listStudents();
	}

	/* (non-Javadoc)
	 * @see com.org.soft.service.StudentService#deleteById(java.lang.String)
	 */
	public void deleteById(int id) {
		studentDao.deleteById(id);
	}


}
