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

import kw.kng.fleetapp.models.Employee;
import kw.kng.fleetapp.models.Country;
import kw.kng.fleetapp.models.State;
import kw.kng.fleetapp.services.EmployeeService;
import kw.kng.fleetapp.services.EmployeeTypeService;
import kw.kng.fleetapp.services.JobTitleService;
import kw.kng.fleetapp.services.CountryService;
import kw.kng.fleetapp.services.StateService;

@Controller
public class EmployeeController
{
	
	@Autowired	EmployeeService emps;
	@Autowired	EmployeeTypeService empts;
	@Autowired	JobTitleService jts;
	@Autowired	CountryService cs;
	@Autowired	StateService ss;
	/*
	 <------------------------------------------ Return List of Employees --------------------------------------------------->
	*/
	@GetMapping("/employee")
	public String getAllEmployeeList(Model model)
	{
		
		
		model.addAttribute("country", cs.listAllCountry());
		model.addAttribute("state", ss.listAllState());
		model.addAttribute("employee", emps.listAllEmployee());
		model.addAttribute("employeetype", empts.listAllEmployeeType());
		model.addAttribute("jobtitle", jts.listAllJobTitle());
		
		return "employee";
	}
	
	/*
	 <------------------------------------------ "Add Employee" button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/employee/addNew")
	public String addNewEmployee(Employee employee)
	{	
		emps.saveEmployee(employee);
		return "redirect:/employee";
		
	}

	/*
	 <------------------------------------------ Edit EmployeeIcon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/employee/findById")
	@ResponseBody
	public Optional<Employee> findById(int id)
	{
	return emps.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit EmployeeIcon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/employee/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateEmployeeRecord(Employee employee)
	{
	emps.saveEmployee(employee);
	return "redirect:/employee";
	}

	/*
	 <------------------------------------------ Delete EmployeeIcon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/employee/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	 emps.deleteEmployee(id);
	return "redirect:/employee";
	}

	/*
	 <------------------------------------------ Assign Employee Username ----------------------------------------------------->
	 */
	
	@RequestMapping(value = "/employee/assignUsername")
	public  String assignUsername(int id){
		emps.assignUsername(id);
		return "redirect:/employees";
	}
}
