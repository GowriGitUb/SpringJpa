/**
 * 
 */
package com.org.soft.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * @author samy
 *
 */
@Entity
@Table(name = "tbl_student")
public class Student {

	/*initialization variable*/
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "REGISTER_NUMBER", nullable = false, unique = true)
	private String registerNumber;
	@Column(name = "NAME", nullable = false)
	private String name;
	@Column(name = "PROFILE_IMAGE")
	@Type(type = "text")
	private String profileImage;
	
	/*dehault constractor*/
	public Student() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", registerNumber=" + registerNumber
				+ ", name=" + name + ", profileImage=" + profileImage + "]";
	}
}
