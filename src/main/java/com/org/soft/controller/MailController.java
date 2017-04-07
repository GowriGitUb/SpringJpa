/**
 * 
 */
package com.org.soft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author samy
 *
 */
@Controller
@RequestMapping("/mail")
public class MailController {
	
	@RequestMapping("chooseCommunication")
	public String communication(){
		return "/email/chooseCommunication";
	}
	
	@RequestMapping("oneWayCommunication")
	public String oneWayCommunication(){
		return "/email/oneWayCommunication";
	}
	
	@RequestMapping("twoWayCommunication")
	public String twoWayCommunication(){
		return "/email/twoWayCommunication";
	}

}
