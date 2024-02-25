package kw.kng.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kw.kng.fleetapp.models.Country;
import kw.kng.fleetapp.models.Contact;
import kw.kng.fleetapp.models.State;
import kw.kng.fleetapp.services.CountryService;
import kw.kng.fleetapp.services.ContactService;
import kw.kng.fleetapp.services.StateService;

@Controller
public class ContactController 
{
	@Autowired	ContactService cos;
	@Autowired	CountryService cs;
	@Autowired	StateService ss;

	/*
	 <------------------------------------------ Return List of Contacts --------------------------------------------------->
	*/
	@GetMapping("/contact")
	public String getAllContactList(Model model)
	{
		List<Country> countryList = cs.listAllCountry();
		List<State> stateList = ss.listAllState();
		List<Contact> contactList = cos.listAllContact();
		
		model.addAttribute("country", countryList);
		model.addAttribute("state", stateList);
		model.addAttribute("contact", contactList);
		return "contact";
	}
	
	/*
	 <------------------------------------------ "Add Contact" button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/contact/addNew")
	public String addNewContact(Contact contact)
	{	
		cos.saveContact(contact);
		return "redirect:/contact";
		
	}

	/*
	 <------------------------------------------ Edit Contact Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/contact/findById")
	@ResponseBody
	public Optional<Contact> findById(int id)
	{
	return cos.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit Contact Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/contact/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateContactRecord(Contact contact)
	{
	cos.saveContact(contact);
	return "redirect:/contact";
	}

	/*
	 <------------------------------------------ Delete Contact Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/contact/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	 cos.deleteContact(id);
	return "redirect:/contact";
	}

}
