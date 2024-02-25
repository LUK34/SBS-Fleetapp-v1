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

import kw.kng.fleetapp.models.VehicleMa;
import kw.kng.fleetapp.services.SupplierService;
import kw.kng.fleetapp.services.VehicleMaService;
import kw.kng.fleetapp.services.VehicleService;

@Controller
public class VehicleMaController 
{

	@Autowired VehicleMaService vms;
	@Autowired VehicleService vs;
	@Autowired SupplierService ss;
	
	/*
	 <------------------------------------------ Return List of VehicleMa --------------------------------------------------->
	*/
	@GetMapping("/vehiclema")
	public String getAllVehicleMaList(Model model)
	{
		model.addAttribute("vehiclema", vms.listAllVehicleMa());
		model.addAttribute("vehicle", vs.listAllVehicle());
		model.addAttribute("supplier", ss.listAllSupplier());
		return "vehiclema";
	}
	/*
	 <------------------------------------------ "Add VehicleMa" Button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/vehiclema/addNew")
	public String addNewVehicleMa(VehicleMa vehiclema)
	{	
		vms.saveVehicleMa(vehiclema);
		return "redirect:/vehiclema";
		
	}
	
	/*
	 <------------------------------------------ Edit VehicleMa Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/vehiclema/findById")
	@ResponseBody
	public Optional<VehicleMa> findById(int id)
	{
	return vms.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit VehicleMa Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/vehiclema/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleMaRecord(VehicleMa vehiclema)
	{
	vms.saveVehicleMa(vehiclema);
	return "redirect:/vehiclema";
	}

	/*
	 <------------------------------------------ Delete VehicleMa Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/vehiclema/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	vms.deleteVehicleMa(id);
	return "redirect:/vehiclema";
	}
}
