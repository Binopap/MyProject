package com.miraglo.egas.mvc.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wordnik.swagger.annotations.Api;

@Api(value="asdasd",description="test")
@Controller
public class DashController {

	@RequestMapping("index.html")
	public String indexController(){
		return "index";
	}
	
	@RequestMapping("dashboard.html")
	@Secured("ROLE_Administrator")
	public String adminController(){
		return "index";
	}
	
	@RequestMapping("login.html")
	public String loginController(){
		return "login";
	}
}
