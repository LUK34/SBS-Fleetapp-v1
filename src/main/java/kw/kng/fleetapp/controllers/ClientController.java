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

import kw.kng.fleetapp.models.Client;
import kw.kng.fleetapp.models.Country;
import kw.kng.fleetapp.models.State;
import kw.kng.fleetapp.services.ClientService;
import kw.kng.fleetapp.services.CountryService;
import kw.kng.fleetapp.services.StateService;

@Controller
public class ClientController
{
	

	@Autowired	ClientService cls;
	@Autowired	CountryService cs;
	@Autowired	StateService ss;

	/*
	 <------------------------------------------ Return List of Clients --------------------------------------------------->
	*/
	@GetMapping("/client")
	public String getAllClientList(Model model)
	{
		List<Country> countryList = cs.listAllCountry();
		List<State> stateList = ss.listAllState();
		List<Client> clientList = cls.listAllClient();
		
		model.addAttribute("country", countryList);
		model.addAttribute("state", stateList);
		model.addAttribute("client", clientList);
		return "client";
	}
	
	/*
	 <------------------------------------------ "Add Client" button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/client/addNew")
	public String addNewClient(Client client)
	{	
		cls.saveClient(client);
		return "redirect:/client";
		
	}

	/*
	 <------------------------------------------ Edit ClientIcon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/client/findById")
	@ResponseBody
	public Optional<Client> findById(int id)
	{
	return cls.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit ClientIcon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/client/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateClientRecord(Client client)
	{
	cls.saveClient(client);
	return "redirect:/client";
	}

	/*
	 <------------------------------------------ Delete ClientIcon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/client/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	 cls.deleteClient(id);
	return "redirect:/client";
	}

}
