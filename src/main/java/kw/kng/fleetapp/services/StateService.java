package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.State;
import kw.kng.fleetapp.repositories.StateRepository;

@Service
public class StateService 
{
	@Autowired
	StateRepository sr;
	
	/*
	 <------------------------------------------ Return List of States --------------------------------------------------->
	*/
	public List<State> listAllState()
	{
		return sr.findAll();
		
	}
	
	/*
	 <------------------------------------------ Add State ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveState(State state)
	{
		sr.save(state);
	}
	
	/*
	 <------------------------------------------ Edit State Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<State> findById(int id)
	{
	return sr.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete State Icon ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteState(Integer id)
	{
		sr.deleteById(id);
	}

	
	
	
	
	
}
