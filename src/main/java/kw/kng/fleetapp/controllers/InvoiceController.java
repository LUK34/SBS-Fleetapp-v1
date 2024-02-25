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


import kw.kng.fleetapp.models.Invoice;
import kw.kng.fleetapp.services.ClientService;
import kw.kng.fleetapp.services.InvoiceService;
import kw.kng.fleetapp.services.InvoiceStatusService;

@Controller
public class InvoiceController 
{
	@Autowired	InvoiceService is;
	@Autowired	InvoiceStatusService iss;
	@Autowired	ClientService cs;
	
	/*
	 <------------------------------------------ Return List of Invoice --------------------------------------------------->
	*/
	@GetMapping("/invoice")
	public String getAllInvoiceList(Model model)
	{		
		model.addAttribute("client", cs.listAllClient());
		model.addAttribute("invoice", is.listAllInvoice());
		model.addAttribute("invoicestatus", iss.listAllInvoiceStatus());
		return "invoice";
	}
	
	/*
	 <------------------------------------------ "Add Invoice" button ->Save button Logic --------------------------------------------------->
	*/
		
	@PostMapping("/invoice/addNew")
	public String addNewInvoice(Invoice invoice)
	{	
		is.saveInvoice(invoice);
		return "redirect:/invoice";
		
	}

	/*
	 <------------------------------------------ Edit Invoice Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping("/invoice/findById")
	@ResponseBody
	public Optional<Invoice> findById(int id)
	{
		return is.findById(id);
	}
	
	/*
	 <------------------------------------------ Edit Invoice Icon ->After Editing, "Update" button logic --------------------------------------------------->
	*/
	@RequestMapping(value="/invoice/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateInvoiceRecord(Invoice invoice)
	{
		is.saveInvoice(invoice);
		return "redirect:/invoice";
	}

	/*
	 <------------------------------------------ Delete Invoice Icon ->Delete record by id logic --------------------------------------------------->
	*/
	
	@RequestMapping(value="/invoice/deleteById", method={RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
		is.deleteInvoice(id);
		return "redirect:/invoice";
	}

}
