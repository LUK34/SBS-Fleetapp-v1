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


import kw.kng.fleetapp.models.InvoiceStatus;


import kw.kng.fleetapp.services.InvoiceStatusService;


@Controller
public class InvoiceStatusController 
{
	@Autowired	InvoiceStatusService is;

	/*
	 <------------------------------------------ Return List of InvoiceStatus --------------------------------------------------->
	*/
	@GetMapping("/invoicestatus")
	public String getAllInvoiceStatusList(Model model)
	{
		List<InvoiceStatus> invoicestatusList = is.listAllInvoiceStatus();
		
		model.addAttribute("invoicestatus", invoicestatusList);
		return "invoicestatus";
	}
	
	/*
	 <------------------------------------------ "Add InvoiceStatus" button ->Save button Logic --------------------------------------------------->
	*/
	
	@PostMapping("/invoicestatus/addNew")
	public String addNewInvoiceStatus(InvoiceStatus invoicestatus)
	{	
		is.saveInvoiceStatus(invoicestatus);
		return "redirect:/invoicestatus";
		
	}

	/*
	 <------------------------------------------ Edit InvoiceStatus Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/invoicestatus/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findById(int id)
	{
	return is.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit InvoiceStatus Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/invoicestatus/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateInvoiceStatusRecord(InvoiceStatus invoicestatus)
	{
	is.saveInvoiceStatus(invoicestatus);
	return "redirect:/invoicestatus";
	}

	/*
	 <------------------------------------------ Delete InvoiceStatus Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/invoicestatus/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
	 is.deleteInvoiceStatus(id);
	return "redirect:/invoicestatus";
	}

}
