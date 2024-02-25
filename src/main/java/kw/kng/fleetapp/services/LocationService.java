package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.Location;
import kw.kng.fleetapp.repositories.LocationRepository;


@Service
public class LocationService 
{
	
	@Autowired
	LocationRepository lr;
	
	/*
	 <------------------------------------------ Return List of Locations --------------------------------------------------->
	*/
	public List<Location> listAllLocation()
	{
		return lr.findAll();
		
	}
	
	/*
	 <------------------------------------------ Add Location ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveLocation(Location location)
	{
		lr.save(location);
	}
	
	/*
	 <------------------------------------------ Edit Location Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<Location> findById(int id)
	{
	return lr.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete Location Icon ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteLocation(Integer id)
	{
		lr.deleteById(id);
	}


}
