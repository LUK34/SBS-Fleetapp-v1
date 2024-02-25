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


import kw.kng.fleetapp.models.VehicleMake;

import kw.kng.fleetapp.services.VehicleMakeService;


@Controller
public class VehicleMakeController 
{
	@Autowired	VehicleMakeService vm;

	/*
	 <------------------------------------------ Return List of VehicleMakes --------------------------------------------------->
	*/
	@GetMapping("/vehiclemake")
	public String getAllVehicleMakeList(Model model)
	{
		List<VehicleMake> vehiclemakeList = vm.listAllVehicleMake();
		
		model.addAttribute("vehiclemake", vehiclemakeList);
		return "vehiclemake";
	}
	
	/*
	 <------------------------------------------ "Add VehicleMake" button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/vehiclemake/addNew")
	public String addNewVehicleMake(VehicleMake vehiclemake)
	{	
		vm.saveVehicleMake(vehiclemake);
		return "redirect:/vehiclemake";
		
	}

	/*
	 <------------------------------------------ Edit VehicleMake Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/vehiclemake/findById")
	@ResponseBody
	public Optional<VehicleMake> findById(int id)
	{
	return vm.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit VehicleMake Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/vehiclemake/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleMakeRecord(VehicleMake vehiclemake)
	{
	vm.saveVehicleMake(vehiclemake);
	return "redirect:/vehiclemake";
	}

	/*
	 <------------------------------------------ Delete VehicleMake Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/vehiclemake/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	 vm.deleteVehicleMake(id);
	return "redirect:/vehiclemake";
	}

}
