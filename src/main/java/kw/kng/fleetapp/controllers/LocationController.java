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
import kw.kng.fleetapp.models.Location;
import kw.kng.fleetapp.models.State;
import kw.kng.fleetapp.services.CountryService;
import kw.kng.fleetapp.services.LocationService;
import kw.kng.fleetapp.services.StateService;


@Controller
public class LocationController
{
	
	@Autowired	LocationService ls;
	@Autowired	CountryService cs;
	@Autowired	StateService ss;

	/*
	 <------------------------------------------ Return List of Locations --------------------------------------------------->
	*/
	@GetMapping("/location")
	public String getAllLocationList(Model model)
	{
		List<Country> countryList = cs.listAllCountry();
		List<State> stateList = ss.listAllState();
		List<Location> locationList = ls.listAllLocation();
		
		model.addAttribute("country", countryList);
		model.addAttribute("state", stateList);
		model.addAttribute("location", locationList);
		return "location";
	}
	
	/*
	 <------------------------------------------ "Add Location" button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/location/addNew")
	public String addNewLocation(Location location)
	{	
		ls.saveLocation(location);
		return "redirect:/location";
		
	}

	/*
	 <------------------------------------------ Edit Location Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/location/findById")
	@ResponseBody
	public Optional<Location> findById(int id)
	{
	return ls.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit Location Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/location/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateLocationRecord(Location location)
	{
	ls.saveLocation(location);
	return "redirect:/location";
	}

	/*
	 <------------------------------------------ Delete Location Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/location/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	 ls.deleteLocation(id);
	return "redirect:/location";
	}

}
