package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.VehicleMa;
import kw.kng.fleetapp.repositories.VehicleMaRepository;

@Service
public class VehicleMaService
{

	@Autowired
	VehicleMaRepository vmr;
	
	/*
	 <------------------------------------------ Return List of VehicleMa --------------------------------------------------->
	*/
	
	public List<VehicleMa> listAllVehicleMa()
	{
		return vmr.findAll();
		
	}
	/*
	 <------------------------------------------ Add VehicleMa Button ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveVehicleMa(VehicleMa vehiclema)
	{
		vmr.save(vehiclema);
	}
	
	/*
	 <------------------------------------------ Edit VehicleMa Button ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<VehicleMa> findById(int id)
	{
	return vmr.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete VehicleMa Button ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteVehicleMa(Integer id)
	{
	vmr.deleteById(id);
	}

}
