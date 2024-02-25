package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.VehicleMovement;
import kw.kng.fleetapp.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService 
{
	@Autowired
	private VehicleMovementRepository vr;
	
	/*
	 <------------------------------------------ Return List of VehicleMovements --------------------------------------------------->
	*/
	public List<VehicleMovement> listAllVehicleMovement()
	{
		return vr.findAll();
		
	}
	
	/*
	 <------------------------------------------ Add VehicleMovement ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveVehicleMovement(VehicleMovement vehiclemovement)
	{
		vr.save(vehiclemovement);
	}
	
	/*
	 <------------------------------------------ Edit VehicleMovement Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<VehicleMovement> findById(int id)
	{
	return vr.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete VehicleMovement Icon ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteVehicleMovement(Integer id)
	{
		vr.deleteById(id);
	}
}
