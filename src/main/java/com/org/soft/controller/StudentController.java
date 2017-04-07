/**
 * 
 */
package com.org.soft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.org.soft.domain.Student;
import com.org.soft.service.StudentService;

/**
 * @author samy
 *
 */
@Controller
@RequestMapping("/student/")
public class StudentController {
	
	private static final String HOME = "redirect:/student/listStudents";
	
	@Autowired(required=true)
	private HttpSession httpSession;
	
	private StudentService studentService;

	public StudentController() {
	}

	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@RequestMapping(value="addStudent")
	public String addStudent(Model model , HttpServletRequest request){
		model.addAttribute("student", new Student());
		httpSession = request.getSession();
		if(httpSession != null && httpSession.getAttribute("username") != null){
			return "/student/addStudent";
		}
		return "login";
	}
	
	@RequestMapping(value="addStudent" , method=RequestMethod.POST)
	public String addStudent(Model model ,@ModelAttribute Student student,
			@RequestParam CommonsMultipartFile fileUpload , HttpServletRequest request){
		model.addAttribute("student", new Student());
		httpSession = request.getSession();
		if(httpSession != null && httpSession.getAttribute("username") != null){
		if(student != null){
			student.setProfileImage(Base64.encodeBase64String(fileUpload.getBytes()));
			studentService.addStudent(student);
		}
			return HOME;
		}
		return "login";
	}
	
	@RequestMapping("listStudents")
	public String listStudent(Model model , @ModelAttribute Student student, HttpServletRequest request){
		httpSession = request.getSession();
		if(httpSession != null && httpSession.getAttribute("username") != null){
			getList(model);
			return "/student/listStudents";
		}
		return "login";
		
	}

	private void getList(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("students", studentService.listStudents());
	}
	
	@RequestMapping("edit")
	public String editStudent(Model model , @RequestParam int id, HttpServletRequest request){
		httpSession = request.getSession();
		if(httpSession != null && httpSession.getAttribute("username") != null){
		if(id != 0){
		Student student = studentService.getById(id);
		model.addAttribute("student", student);
		return "/student/addStudent";
		}
		}
		return "login";
	}
	
	
	@RequestMapping("delete")
	public String deleteStudent(Model model , @RequestParam int id, HttpServletRequest request){
		httpSession = request.getSession();
		if(httpSession != null && httpSession.getAttribute("username") != null){
		if(id !=  0 ){
			studentService.deleteById(id);
			getList(model);
			return HOME;
		}
		}
		return "login";
	}
}
