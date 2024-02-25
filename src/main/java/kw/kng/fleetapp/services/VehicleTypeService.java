package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.VehicleType;
import kw.kng.fleetapp.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService 
{
	@Autowired
	VehicleTypeRepository vtyprepo;
	
	/*
	 <------------------------------------------ Return List of VehicleType --------------------------------------------------->
	*/
	public List<VehicleType> listAllVehicleType()
	{
		return vtyprepo.findAll();
		
	}
	
	/*
	 <------------------------------------------ Add VehicleType ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveVehicleType(VehicleType vehicletype)
	{
		vtyprepo.save(vehicletype);
	}
	
	/*
	 <------------------------------------------ Edit VehicleType Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<VehicleType> findById(int id)
	{
	return vtyprepo.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete VehicleType Icon ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteVehicleType(Integer id)
	{
		vtyprepo.deleteById(id);
	}

}
