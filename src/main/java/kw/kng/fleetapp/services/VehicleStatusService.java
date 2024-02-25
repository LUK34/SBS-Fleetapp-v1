package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.VehicleStatus;
import kw.kng.fleetapp.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService
{
	@Autowired
	VehicleStatusRepository vstatusrepo;
	
	/*
	 <------------------------------------------ Return List of Locations --------------------------------------------------->
	*/
	public List<VehicleStatus> listAllVehicleStatus()
	{
		return vstatusrepo.findAll();
		
	}
	
	/*
	 <------------------------------------------ Add Location ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveVehicleStatus(VehicleStatus vehiclestatus)
	{
		vstatusrepo.save(vehiclestatus);
	}
	
	/*
	 <------------------------------------------ Edit Location Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<VehicleStatus> findById(int id)
	{
	return vstatusrepo.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete Location Icon ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteVehicleStatus(Integer id)
	{
		vstatusrepo.deleteById(id);
	}

}
