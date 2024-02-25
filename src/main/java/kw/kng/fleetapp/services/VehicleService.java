package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.Vehicle;
import kw.kng.fleetapp.repositories.VehicleRepository;

@Service
public class VehicleService
{
	

	@Autowired
	VehicleRepository vr;
	
	/*
	 <------------------------------------------ Return List of VehicleService --------------------------------------------------->
	*/
	
	public List<Vehicle> listAllVehicle()
	{
		return vr.findAll();
		
	}
	/*
	 <------------------------------------------ Add VehicleService Button ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveVehicle(Vehicle vehicle)
	{
		vr.save(vehicle);
	}
	
	/*
	 <------------------------------------------ Edit VehicleService Button ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<Vehicle> findById(int id)
	{
	return vr.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete VehicleService Button ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteVehicle(Integer id)
	{
		vr.deleteById(id);
	}


}
