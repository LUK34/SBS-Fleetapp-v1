package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.Client;
import kw.kng.fleetapp.repositories.ClientRepository;

@Service
public class ClientService 
{
	@Autowired
	ClientRepository clr;
	
	/*
	 <------------------------------------------ Return List of Clients --------------------------------------------------->
	*/
	public List<Client> listAllClient()
	{
		return clr.findAll();
		
	}
	
	/*
	 <------------------------------------------ Add Client ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveClient(Client client)
	{
		clr.save(client);
	}
	
	/*
	 <------------------------------------------ Edit Client Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<Client> findById(int id)
	{
	return clr.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete Client Icon ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteClient(Integer id)
	{
		clr.deleteById(id);
	}


}
