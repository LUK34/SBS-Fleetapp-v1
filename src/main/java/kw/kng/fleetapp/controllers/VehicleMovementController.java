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

import kw.kng.fleetapp.models.VehicleMovement;
import kw.kng.fleetapp.services.LocationService;
import kw.kng.fleetapp.services.VehicleMovementService;
import kw.kng.fleetapp.services.VehicleService;

@Controller
public class VehicleMovementController 
{
	@Autowired private VehicleMovementService vms;
	@Autowired private LocationService ls;
	@Autowired private VehicleService vs;
	
	
	/*
	 <------------------------------------------ Return List of VehicleMovement --------------------------------------------------->
	*/
	@GetMapping("/vehiclemovement")
	public String getAllVehicleMovementList(Model model)
	{
		
		model.addAttribute("vehicle", vs.listAllVehicle());
		model.addAttribute("location", ls.listAllLocation());
		model.addAttribute("vehiclemovement", vms.listAllVehicleMovement());
		return "/vehiclemovement";
	}
	/*
	 <------------------------------------------ "Add VehicleMovement" Button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/vehiclemovement/addNew")
	public String addNewVehicleMovement(VehicleMovement vehiclemovement)
	{	
		vms.saveVehicleMovement(vehiclemovement);
		return "redirect:/vehiclemovement";
		
	}
	
	/*
	 <------------------------------------------ Edit VehicleMovement Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/vehiclemovement/findById")
	@ResponseBody
	public Optional<VehicleMovement> findById(int id)
	{
	return vms.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit VehicleMovement Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/vehiclemovement/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleMovementRecord(VehicleMovement vehiclemovement)
	{
	vms.saveVehicleMovement(vehiclemovement);
	return "redirect:/vehiclemovement";
	}

	/*
	 <------------------------------------------ Delete CountVehicleMovementry Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/vehiclemovement/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	vms.deleteVehicleMovement(id);
	return "redirect:/vehiclemovement";
	}
}
