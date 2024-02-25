package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.EmployeeType;
import kw.kng.fleetapp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService 
{
	@Autowired
	EmployeeTypeRepository etyperepo;
	
	/*
	 <------------------------------------------ Return List of EmployeeType --------------------------------------------------->
	*/
	public List<EmployeeType> listAllEmployeeType()
	{
		return etyperepo.findAll();
		
	}
	
	/*
	 <------------------------------------------ Add EmployeeType ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveEmployeeType(EmployeeType employeetype)
	{
		etyperepo.save(employeetype);
	}
	
	/*
	 <------------------------------------------ Edit EmployeeType Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<EmployeeType> findById(int id)
	{
	return etyperepo.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete EmployeeType Icon ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteEmployeeType(Integer id)
	{
		etyperepo.deleteById(id);
	}

}
