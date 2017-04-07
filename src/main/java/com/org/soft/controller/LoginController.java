/**
 * 
 */
package com.org.soft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.org.soft.domain.Login;

/**
 * @author samy
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static final String HOME = "redirect:/student/listStudents";
	
	@Autowired(required = true)
	private HttpSession httpSession;
	
	@RequestMapping("login")
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String login(Model model , @ModelAttribute Login login , HttpServletRequest request){
		httpSession = request.getSession();
		httpSession.setAttribute("username", login.getUsername());
		return HOME;
	}

	@RequestMapping(value="/logout" , method = RequestMethod.GET)
	public String logout(Model model , @ModelAttribute Login login){
		httpSession.removeAttribute("username");
		httpSession.invalidate();
		return "login";
	}
	
	@RequestMapping(value="/test")
	public String test(Model model, HttpServletRequest request){
		httpSession = request.getSession();
		if(httpSession != null && httpSession.getAttribute("username") != null){
			return "welcomeTest";
		}else{
			return "login";
		}
	}
}
