package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.InvoiceStatus;
import kw.kng.fleetapp.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService 
{
	@Autowired
	InvoiceStatusRepository istatusrepo;
	
	/*
	 <------------------------------------------ Return List of InvoiceStatus --------------------------------------------------->
	*/
	public List<InvoiceStatus> listAllInvoiceStatus()
	{
		return istatusrepo.findAll();
		
	}
	
	/*
	 <------------------------------------------ Add InvoiceStatus ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveInvoiceStatus(InvoiceStatus invoicestatus)
	{
		istatusrepo.save(invoicestatus);
	}
	
	/*
	 <------------------------------------------ Edit InvoiceStatus Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<InvoiceStatus> findById(int id)
	{
	return istatusrepo.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete InvoiceStatus Icon ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteInvoiceStatus(Integer id)
	{
		istatusrepo.deleteById(id);
	}

}
