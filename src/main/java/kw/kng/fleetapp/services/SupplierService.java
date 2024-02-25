package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.Supplier;
import kw.kng.fleetapp.repositories.SupplierRepository;


@Service
public class SupplierService 
{
		
	@Autowired
	SupplierRepository sr;
	
	/*
	 <------------------------------------------ Return List of Suppliers --------------------------------------------------->
	*/
	public List<Supplier> listAllSupplier()
	{
		return sr.findAll();
		
	}
	
	/*
	 <------------------------------------------ Add Supplier ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveSupplier(Supplier supplier)
	{
		sr.save(supplier);
	}
	
	/*
	 <------------------------------------------ Edit Supplier Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<Supplier> findById(int id)
	{
	return sr.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete Supplier Icon ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteSupplier(Integer id)
	{
		sr.deleteById(id);
	}



}
