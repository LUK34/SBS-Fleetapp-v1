package kw.kng.fleetapp.security.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.User;
import kw.kng.fleetapp.repositories.UserRepository;
import kw.kng.fleetapp.security.models.Role;
import kw.kng.fleetapp.security.repositories.RoleRepository;

@Service
public class RoleService 
{
	@Autowired
	RoleRepository rrepo;
	
	@Autowired
	UserRepository urepo;
	
	/*
	 <------------------------------------------ Return List of Role --------------------------------------------------->
	*/
	public List<Role> listAllRole()
	{
		return rrepo.findAll();
		
	}
	
	/*
	 <------------------------------------------ Add Role ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveRole(Role role)
	{
		rrepo.save(role);
	}
	
	/*
	 <------------------------------------------ Edit Role Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<Role> findById(int id)
	{
	return rrepo.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete Role Icon ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteRole(Integer id)
	{
		rrepo.deleteById(id);
	}

	/*
	 <------------------------------------------ Assign Role to User --------------------------------------------------->
	*/ 
	
	public void assignUserRole(Integer userId, Integer roleId){
	    User user  = urepo.findById(userId).orElse(null);
	    Role role = rrepo.findById(roleId).orElse(null);
	   Set<Role> userRoles = user.getRoles();
	   userRoles.add(role);
	   user.setRoles(userRoles);
	   urepo.save(user);
	}

	/*
	 <------------------------------------------ Unassign Role to User --------------------------------------------------->
	*/ 
	public void unassignUserRole(Integer userId, Integer roleId){
	    User user  = urepo.findById(userId).orElse(null);
	    user.getRoles().removeIf(x -> x.getId()==roleId); //Predicate( True or false) based function ->Collection Framework
	    urepo.save(user);
	}
	/*
	  <------------------------------------ Get the list of assigned roles from that User ---------------------------------------------------->
	 */
	
	public Set<Role> getUserRoles(User user){
	    return user.getRoles();
	}
	
	/*
	  <------------------------------------ Get the list of unassigned roles from that User ---------------------------------------------------->
	 */
	
	public List<Role> getUserNotRoles(User user)
	{
		   return rrepo.getUserNotRoles(user.getId());
	}
	
	
}


/*

 1. Using urepo we are going to find the user by its id and store it in an object of type user.
 2. Using rrepo we are going to find the role by its id and store it in an object of type role.
 3. We are going to use collection framework ->Set and of type Set
 4. Based on what we have defined in User Model(kw.kng.fleetapp.models) here we will use get method and assign it to
 userRoles
 5. Inorder to assign a specific role to the user we use add method to userRoles
 6. After assigning the role in userRoles we will perform set operation in user.
 7. After doing step 6 we will save it into the dbby calling in the UserRepository urepo.
 8. Th urepo will call the save() method of the JPA repository. 
 9. To unassign the user from its role we do the following
 10. We find the required user by id , if it exist we get the userId else set as null. Store the info in User object
 11. We call the get method of the user. and check if the id exist for that role. If true remove that role.
 we search the role using lambda expression.
 12. After that save the detail UserRepository
 13. The roles that are NOT assigned to the user are coming from the roles table. Go to RolesRepository.
 14. The roles that are assigned to the user are coming from the user table under getRoles.
 
 */