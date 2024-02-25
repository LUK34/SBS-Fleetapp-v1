package kw.kng.fleetapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import kw.kng.fleetapp.models.User;
import kw.kng.fleetapp.services.UserService;

@Controller
public class UserController
{
@Autowired 
private UserService us;
	
/*
 ------------------------------------------- Get All Users----------------------------------------------------------
  */	

	@GetMapping("users")
	public String findAll(Model model){		
		model.addAttribute("users", us.findAll());
		return "user";
	}	
	
	//Modified method to Add a new user User
		@PostMapping(value="users/addNew")
		public RedirectView addNew(User user, RedirectAttributes redir) {
			us.save(user);	
			RedirectView  redirectView= new RedirectView("/login",true);
		    redir.addFlashAttribute("message",
		    		"You successfully registered! You can now login");
		    return redirectView;				
		}	

}
