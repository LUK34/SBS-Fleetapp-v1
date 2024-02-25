package kw.kng.fleetapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController
{
	
	@GetMapping("/accessdenied")
	public String getAccessDeniedPage()
	{
		return "accessdenied";
	}
	
	@GetMapping("/index")
	public String getIndexPage()
	{
		return "blank";
	}

	@GetMapping("/login")
	public String loginPage()
	{
		return "login";
	}
	

	@GetMapping("/logout")
	public String logoutPage()
	{
		return "login";
	}
	
	@GetMapping("/register")
	public String registerPage()
	{
		return "register";
	}

}
