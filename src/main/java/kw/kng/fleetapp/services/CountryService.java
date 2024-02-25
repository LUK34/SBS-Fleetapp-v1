package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.Country;
import kw.kng.fleetapp.repositories.CountryRepository;

@Service
public class CountryService
{

	@Autowired
	CountryRepository cr;
	
	/*
	 <------------------------------------------ Return List of Countries --------------------------------------------------->
	*/
	
	public List<Country> listAllCountry()
	{
		return cr.findAll();
		
	}
	/*
	 <------------------------------------------ Add Country Button ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveCountry(Country country)
	{
		cr.save(country);
	}
	
	/*
	 <------------------------------------------ Edit Country Button ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<Country> findById(int id)
	{
	return cr.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete Country Button ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteCountry(Integer id)
	{
	cr.deleteById(id);
	}

}
