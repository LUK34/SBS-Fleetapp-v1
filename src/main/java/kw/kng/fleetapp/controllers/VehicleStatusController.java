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


import kw.kng.fleetapp.models.VehicleStatus;

import kw.kng.fleetapp.services.VehicleStatusService;


@Controller
public class VehicleStatusController 
{
	@Autowired	VehicleStatusService vs;
	/*
	 <------------------------------------------ Return List of VehicleStatus --------------------------------------------------->
	*/
	@GetMapping("/vehiclestatus")
	public String getAllVehicleStatusList(Model model)
	{
		List<VehicleStatus> vehiclestatusList = vs.listAllVehicleStatus();
		model.addAttribute("vehiclestatus", vehiclestatusList);
		return "vehiclestatus";
	}
	
	/*
	 <------------------------------------------ "Add VehicleStatus" button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/vehiclestatus/addNew")
	public String addNewVehicleStatus(VehicleStatus vehiclestatus)
	{	
		vs.saveVehicleStatus(vehiclestatus);
		return "redirect:/vehiclestatus";
		
	}

	/*
	 <------------------------------------------ Edit VehicleStatus Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/vehiclestatus/findById")
	@ResponseBody
	public Optional<VehicleStatus> findById(int id)
	{
	return vs.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit VehicleStatus Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/vehiclestatus/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleStatusRecord(VehicleStatus vehiclestatus)
	{
	vs.saveVehicleStatus(vehiclestatus);
	return "redirect:/vehiclestatus";
	}

	/*
	 <------------------------------------------ Delete VehicleStatus Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/vehiclestatus/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	 vs.deleteVehicleStatus(id);
	return "redirect:/vehiclestatus";
	}

}
