package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.Contact;
import kw.kng.fleetapp.repositories.ContactRepository;

@Service
public class ContactService
{

	@Autowired
	ContactRepository cr;
	
	/*
	 <------------------------------------------ Return List of Contacts --------------------------------------------------->
	*/
	
	public List<Contact> listAllContact()
	{
		return cr.findAll();
		
	}
	/*
	 <------------------------------------------ Add Contact Button ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveContact(Contact contact)
	{
		cr.save(contact);
	}
	
	/*
	 <------------------------------------------ Edit Contact Button ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<Contact> findById(int id)
	{
	return cr.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete Contact Button ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteContact(Integer id)
	{
	cr.deleteById(id);
	}

}
