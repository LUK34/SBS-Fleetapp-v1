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


import kw.kng.fleetapp.models.VehicleMaintain;
import kw.kng.fleetapp.services.VehicleMaintainService;
import kw.kng.fleetapp.services.VehicleService;
import kw.kng.fleetapp.services.SupplierService;

@Controller
public class VehicleMaintainController 
{
	@Autowired	VehicleMaintainService vms;
	@Autowired	VehicleService vs;
	@Autowired	SupplierService ss;

	/*
	 <------------------------------------------ Return List of VehicleMaintenances --------------------------------------------------->
	*/
	@GetMapping("/vehiclemaintain")
	public String getAllVehicleMaintenanceList(Model model)
	{		
		model.addAttribute("vehicle", vs.listAllVehicle());
		model.addAttribute("supplier", ss.listAllSupplier());
		model.addAttribute("vehiclemaintain", vms.listAllVehicleMaintenance());
		return "vehiclemaintain";
	}
	
	/*
	 <------------------------------------------ "Add VehicleMaintenance" button ->Save button Logic --------------------------------------------------->
	*/
		
	@PostMapping("/vehiclemaintain/addNew")
	public String addNewVehicleMaintenance(VehicleMaintain vehiclemaintain)
	{	
		vms.saveVehicleMaintenance(vehiclemaintain);
		return "redirect:/vehiclemaintain";
		
	}

	/*
	 <------------------------------------------ Edit VehicleMaintenance Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/vehiclemaintain/findById")
	@ResponseBody
	public Optional<VehicleMaintain> findById(int id)
	{
	return vms.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit VehicleMaintenance Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/vehiclemaintain/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleMaintenanceRecord(VehicleMaintain vehiclemaintain)
	{
	vms.saveVehicleMaintenance(vehiclemaintain);
	return "redirect:/vehiclemaintain";
	}

	/*
	 <------------------------------------------ Delete VehicleMaintenance Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/vehiclemaintain/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	 vms.deleteVehicleMaintenance(id);
	return "redirect:/vehiclemaintain";
	}

}
