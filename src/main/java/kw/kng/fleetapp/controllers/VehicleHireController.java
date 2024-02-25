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

import kw.kng.fleetapp.models.VehicleHire;
import kw.kng.fleetapp.services.LocationService;
import kw.kng.fleetapp.services.VehicleHireService;
import kw.kng.fleetapp.services.ClientService;
import kw.kng.fleetapp.services.VehicleService;

@Controller
public class VehicleHireController 
{
	@Autowired private VehicleHireService vhs;
	@Autowired private ClientService cs;
	@Autowired private LocationService ls;
	@Autowired private VehicleService vs;
	
	
	/*
	 <------------------------------------------ Return List of VehicleHire --------------------------------------------------->
	*/
	@GetMapping("/vehiclehire")
	public String getAllVehicleHireList(Model model)
	{
		model.addAttribute("client", cs.listAllClient());
		model.addAttribute("vehicle", vs.listAllVehicle());
		model.addAttribute("location", ls.listAllLocation());
		model.addAttribute("vehiclehire", vhs.listAllVehicleHire());
		return "/vehiclehire";
	}
	/*
	 <------------------------------------------ "Add VehicleHire" Button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/vehiclehire/addNew")
	public String addNewVehicleHire(VehicleHire vehiclehire)
	{	
		vhs.saveVehicleHire(vehiclehire);
		return "redirect:/vehiclehire";
		
	}
	
	/*
	 <------------------------------------------ Edit VehicleHire Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/vehiclehire/findById")
	@ResponseBody
	public Optional<VehicleHire> findById(int id)
	{
	return vhs.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit VehicleHire Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/vehiclehire/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleHireRecord(VehicleHire vehiclehire)
	{
	vhs.saveVehicleHire(vehiclehire);
	return "redirect:/vehiclehire";
	}

	/*
	 <------------------------------------------ Delete VehicleHire Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/vehiclehire/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	vhs.deleteVehicleHire(id);
	return "redirect:/vehiclehire";
	}
}
