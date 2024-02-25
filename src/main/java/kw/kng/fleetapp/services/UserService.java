package kw.kng.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.User;
import kw.kng.fleetapp.repositories.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository ur;
	
	/*
	 ------------------------------------------- Get All Users----------------------------------------------------------
	  */	

	public List<User> findAll()
	{
		return ur.findAll();
	}	
	
	/*
	 ------------------------------------------- Get User By Id----------------------------------------------------------
	  */	

	//
	public User findById(int id) 
	{
		return ur.findById(id).orElse(null);
	}	
	
	/*
	 ------------------------------------------- Delete User----------------------------------------------------------
	  */
	
	public void delete(int id) 
	{
		ur.deleteById(id);
	}
	
	/*
	 ------------------------------------------- Update User----------------------------------------------------------
	  */

	
	  public void save(User user) {
	 // user.setPassword(encoder.encode(user.getPassword())); ur.save(user); 
		  ur.save(user);
	  }
	
}
