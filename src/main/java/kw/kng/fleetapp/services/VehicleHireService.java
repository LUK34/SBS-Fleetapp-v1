package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.VehicleHire;
import kw.kng.fleetapp.repositories.VehicleHireRepository;

@Service
public class VehicleHireService 
{
	@Autowired
	private VehicleHireRepository vr;
	
	/*
	 <------------------------------------------ Return List of VehicleHire --------------------------------------------------->
	*/
	public List<VehicleHire> listAllVehicleHire()
	{
		return vr.findAll();
		
	}
	
	/*
	 <------------------------------------------ Add VehicleHire ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveVehicleHire(VehicleHire vehiclehire)
	{
		vr.save(vehiclehire);
	}
	
	/*
	 <------------------------------------------ Edit VehicleHire Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<VehicleHire> findById(int id)
	{
	return vr.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete VehicleHire Icon ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteVehicleHire(Integer id)
	{
		vr.deleteById(id);
	}
}
