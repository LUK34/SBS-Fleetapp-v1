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

import kw.kng.fleetapp.models.Country;
import kw.kng.fleetapp.models.Supplier;
import kw.kng.fleetapp.models.State;
import kw.kng.fleetapp.services.CountryService;
import kw.kng.fleetapp.services.SupplierService;
import kw.kng.fleetapp.services.StateService;

@Controller
public class SupplierController 
{
	@Autowired	SupplierService sus;
	@Autowired	CountryService cs;
	@Autowired	StateService ss;

	/*
	 <------------------------------------------ Return List of Suppliers --------------------------------------------------->
	*/
	@GetMapping("/supplier")
	public String getAllSupplierList(Model model)
	{
		List<Country> countryList = cs.listAllCountry();
		List<State> stateList = ss.listAllState();
		List<Supplier> supplierList = sus.listAllSupplier();
		
		model.addAttribute("country", countryList);
		model.addAttribute("state", stateList);
		model.addAttribute("supplier", supplierList);
		return "supplier";
	}
	
	/*
	 <------------------------------------------ "Add Supplier" button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/supplier/addNew")
	public String addNewSupplier(Supplier supplier)
	{	
		sus.saveSupplier(supplier);
		return "redirect:/supplier";
		
	}

	/*
	 <------------------------------------------ Edit Supplier Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/supplier/findById")
	@ResponseBody
	public Optional<Supplier> findById(int id)
	{
	return sus.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit Supplier Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/supplier/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateSupplierRecord(Supplier supplier)
	{
	sus.saveSupplier(supplier);
	return "redirect:/supplier";
	}

	/*
	 <------------------------------------------ Delete Supplier Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/supplier/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	 sus.deleteSupplier(id);
	return "redirect:/supplier";
	}

}
