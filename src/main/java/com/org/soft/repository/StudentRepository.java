/**
 * 
 */
package com.org.soft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.soft.domain.Student;

/**
 * @author samy
 *
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
