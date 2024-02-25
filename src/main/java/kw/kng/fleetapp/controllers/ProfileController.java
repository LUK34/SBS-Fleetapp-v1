package kw.kng.fleetapp.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kw.kng.fleetapp.services.EmployeeService;

@Controller
public class ProfileController 
{
	@Autowired
    private EmployeeService es;
	
	@RequestMapping(value="/profile")
    public String profile(Model model, Principal principal) {
        String un = principal.getName();
        model.addAttribute("employee", es.findByUsername(un));
        return "profile";
    }
    
    

}


/*
 1. Principal is the method that will get the logged in user. 
 2. We get the name of the logged in user and call the employeeService.
 3. In the employeeService there is a method called findByUsername which will interact
 with repository and get the details of the employee from the db
 
 
 
 */

