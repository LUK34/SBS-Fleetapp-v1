package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.VehicleModel;
import kw.kng.fleetapp.repositories.VehicleModelRepository;

@Service
public class VehicleModelService 
{
	@Autowired
	VehicleModelRepository vmodelrepo;
	
	/*
	 <------------------------------------------ Return List of VehicleModel --------------------------------------------------->
	*/
	public List<VehicleModel> listAllVehicleModel()
	{
		return vmodelrepo.findAll();
		
	}
	
	/*
	 <------------------------------------------ Add VehicleModel ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveVehicleModel(VehicleModel vehiclemodel)
	{
		vmodelrepo.save(vehiclemodel);
	}
	
	/*
	 <------------------------------------------ Edit VehicleModel Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<VehicleModel> findById(int id)
	{
	return vmodelrepo.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete VehicleModel Icon ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteVehicleModel(Integer id)
	{
		vmodelrepo.deleteById(id);
	}

}
