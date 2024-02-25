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
import kw.kng.fleetapp.services.CountryService;

@Controller
public class CountryController
{
	@Autowired
	CountryService cs;
	
	/*
	 <------------------------------------------ Return List of Countries --------------------------------------------------->
	*/
	@GetMapping("/country")
	public String getAllCountryList(Model model)
	{
		List<Country> countryList = cs.listAllCountry();
		model.addAttribute("country", countryList);
		return "country";
	}
	/*
	 <------------------------------------------ "Add Country" Button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/country/addNew")
	public String addNewCountry(Country country)
	{	
		cs.saveCountry(country);
		return "redirect:/country";
		
	}
	
	/*
	 <------------------------------------------ Edit Country Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/country/findById")
	@ResponseBody
	public Optional<Country> findById(int id)
	{
	return cs.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit Country Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/country/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateCountryRecord(Country country)
	{
	cs.saveCountry(country);
	return "redirect:/country";
	}

	/*
	 <------------------------------------------ Delete Country Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/country/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	cs.deleteCountry(id);
	return "redirect:/country";
	}
	
	
	
}
