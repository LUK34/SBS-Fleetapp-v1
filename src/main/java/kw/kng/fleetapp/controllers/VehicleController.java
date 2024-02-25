package kw.kng.fleetapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kw.kng.fleetapp.models.Vehicle;
import kw.kng.fleetapp.services.EmployeeService;
import kw.kng.fleetapp.services.LocationService;
import kw.kng.fleetapp.services.VehicleMakeService;
import kw.kng.fleetapp.services.VehicleModelService;
import kw.kng.fleetapp.services.VehicleService;
import kw.kng.fleetapp.services.VehicleStatusService;
import kw.kng.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleController 
{

	@Autowired VehicleService vs;
	@Autowired VehicleTypeService vts;
	@Autowired VehicleMakeService vmaks;
	@Autowired VehicleModelService vmods;
	@Autowired LocationService ls;
	@Autowired EmployeeService es ;
	@Autowired VehicleStatusService vss;
	
	/*
	 <------------------------------------------ Return List of Countries --------------------------------------------------->
	*/
	@GetMapping("/vehicle")
	public String getAllVehicleList(Model model)
	{
		model.addAttribute("vehicle", vs.listAllVehicle());
		model.addAttribute("vehicletype", vts.listAllVehicleType());
		model.addAttribute("vehiclemake", vmaks.listAllVehicleMake());
		model.addAttribute("vehiclemodel", vmods.listAllVehicleModel());
		model.addAttribute("location", ls.listAllLocation());
		model.addAttribute("employee", es.listAllEmployee());
		model.addAttribute("vehiclestatus", vss.listAllVehicleStatus());
		
		return "vehicle";
	}
	/*
	 <------------------------------------------ "Add Vehicle" Button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/vehicle/addNew")
	public String addNewVehicle(Vehicle vehicle)
	{	
		vs.saveVehicle(vehicle);
		return "redirect:/vehicle";
		
	}
	
	/*
	 <------------------------------------------ Edit Vehicle Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/vehicle/findById")
	@ResponseBody
	public Optional<Vehicle> findById(int id)
	{
	return vs.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit Vehicle Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/vehicle/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleRecord(Vehicle vehicle)
	{
	vs.saveVehicle(vehicle);
	return "redirect:/vehicle";
	}

	/*
	 <------------------------------------------ Delete Vehicle Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/vehicle/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	vs.deleteVehicle(id);
	return "redirect:/vehicle";
	}
}
