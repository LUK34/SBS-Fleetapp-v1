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


import kw.kng.fleetapp.models.VehicleModel;

import kw.kng.fleetapp.services.VehicleModelService;


@Controller
public class VehicleModelController 
{
	@Autowired	VehicleModelService vm;

	/*
	 <------------------------------------------ Return List of VehicleModel --------------------------------------------------->
	*/
	@GetMapping("/vehiclemodel")
	public String getAllVehicleModelList(Model model)
	{
		List<VehicleModel> vehiclemodelList = vm.listAllVehicleModel();
		
		model.addAttribute("vehiclemodel", vehiclemodelList);
		return "vehiclemodel";
	}
	
	/*
	 <------------------------------------------ "Add VehicleModel" button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/vehiclemodel/addNew")
	public String addNewVehicleModel(VehicleModel vehiclemodel)
	{	
		vm.saveVehicleModel(vehiclemodel);
		return "redirect:/vehiclemodel";
		
	}

	/*
	 <------------------------------------------ Edit VehicleModel Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/vehiclemodel/findById")
	@ResponseBody
	public Optional<VehicleModel> findById(int id)
	{
	return vm.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit VehicleModel Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/vehiclemodel/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleModelRecord(VehicleModel vehiclemodel)
	{
	vm.saveVehicleModel(vehiclemodel);
	return "redirect:/vehiclemodel";
	}

	/*
	 <------------------------------------------ Delete VehicleModel Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/vehiclemodel/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	 vm.deleteVehicleModel(id);
	return "redirect:/vehiclemodel";
	}

}
