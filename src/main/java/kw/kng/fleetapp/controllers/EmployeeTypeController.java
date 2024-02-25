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


import kw.kng.fleetapp.models.EmployeeType;

import kw.kng.fleetapp.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController 
{	
	@Autowired	EmployeeTypeService es;

	/*
	 <------------------------------------------ Return List of EmployeeType --------------------------------------------------->
	*/
	@GetMapping("/employeetype")
	public String getAllEmployeeTypeList(Model model)
	{
		List<EmployeeType> employeetypeList = es.listAllEmployeeType();
		
		model.addAttribute("employeetype", employeetypeList);
		return "employeetype";
	}
	
	/*
	 <------------------------------------------ "Add EmployeeType" button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/employeetype/addNew")
	public String addNewEmployeeType(EmployeeType employeetype)
	{	
		es.saveEmployeeType(employeetype);
		return "redirect:/employeetype";
		
	}

	/*
	 <------------------------------------------ Edit EmployeeType Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/employeetype/findById")
	@ResponseBody
	public Optional<EmployeeType> findById(int id)
	{
	return es.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit EmployeeType Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/employeetype/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateEmployeeTypeRecord(EmployeeType employeetype)
	{
	es.saveEmployeeType(employeetype);
	return "redirect:/employeetype";
	}

	/*
	 <------------------------------------------ Delete EmployeeType Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/employeetype/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	 es.deleteEmployeeType(id);
	return "redirect:/employeetype";
	}

}
