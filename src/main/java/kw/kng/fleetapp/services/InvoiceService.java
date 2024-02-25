package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.Invoice;
import kw.kng.fleetapp.repositories.InvoiceRepository;

@Service
public class InvoiceService
{

	@Autowired
	InvoiceRepository ir;
	
	/*
	 <------------------------------------------ Return List of Invoice --------------------------------------------------->
	*/
	
	public List<Invoice> listAllInvoice()
	{
		return ir.findAll();
		
	}
	/*
	 <------------------------------------------ Add Invoice Button ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveInvoice(Invoice invoice)
	{
		ir.save(invoice);
	}
	
	/*
	 <------------------------------------------ Edit Invoice Button ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<Invoice> findById(int id)
	{
	return ir.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete Invoice Button ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteInvoice(Integer id)
	{
	ir.deleteById(id);
	}

}
