package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.VehicleMaintain;
import kw.kng.fleetapp.repositories.VehicleMaintainRepository;

@Service
public class VehicleMaintainService
{

	@Autowired
	VehicleMaintainRepository vmr;
	
	/*
	 <------------------------------------------ Return List of VehicleMaintenances --------------------------------------------------->
	*/
	
	public List<VehicleMaintain> listAllVehicleMaintenance()
	{
		return vmr.findAll();
		
	}
	/*
	 <------------------------------------------ Add VehicleMaintenance Button ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveVehicleMaintenance(VehicleMaintain vehiclemain)
	{
		vmr.save(vehiclemain);
	}
	
	/*
	 <------------------------------------------ Edit VehicleMaintenance Button ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<VehicleMaintain> findById(int id)
	{
	return vmr.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete VehicleMaintenance Button ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteVehicleMaintenance(Integer id)
	{
	vmr.deleteById(id);
	}

}
