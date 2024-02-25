package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.VehicleMake;
import kw.kng.fleetapp.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService
{
	@Autowired
	VehicleMakeRepository vmakerepo;
	
	/*
	 <------------------------------------------ Return List of VehicleMakes --------------------------------------------------->
	*/
	public List<VehicleMake> listAllVehicleMake()
	{
		return vmakerepo.findAll();
		
	}
	
	/*
	 <------------------------------------------ Add VehicleMake ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveVehicleMake(VehicleMake vehiclemake)
	{
		vmakerepo.save(vehiclemake);
	}
	
	/*
	 <------------------------------------------ Edit VehicleMake Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<VehicleMake> findById(int id)
	{
	return vmakerepo.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete VehicleMake Icon ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteVehicleMake(Integer id)
	{
		vmakerepo.deleteById(id);
	}

}

/*

*/