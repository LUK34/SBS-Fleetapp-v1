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

import kw.kng.fleetapp.models.VehicleType;


import kw.kng.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleTypeController
{
	@Autowired	VehicleTypeService vt;
	

	/*
	 <------------------------------------------ Return List of VehicleType --------------------------------------------------->
	*/
	@GetMapping("/vehicletype")
	public String getAllVehicleTypeList(Model model)
	{
		
		List<VehicleType> vehicletypeList = vt.listAllVehicleType();
		
		model.addAttribute("vehicletype", vehicletypeList);
		return "vehicletype";
	}
	
	/*
	 <------------------------------------------ "Add VehicleType" button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/vehicletype/addNew")
	public String addNewVehicleType(VehicleType vehicletype)
	{	
		vt.saveVehicleType(vehicletype);
		return "redirect:/vehicletype";
		
	}

	/*
	 <------------------------------------------ Edit VehicleType Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/vehicletype/findById")
	@ResponseBody
	public Optional<VehicleType> findById(int id)
	{
	return vt.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit VehicleType Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/vehicletype/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleTypeRecord(VehicleType vehicletype)
	{
	vt.saveVehicleType(vehicletype);
	return "redirect:/vehicletype";
	}

	/*
	 <------------------------------------------ Delete VehicleType Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/vehicletype/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	 vt.deleteVehicleType(id);
	return "redirect:/vehicletype";
	}

}
