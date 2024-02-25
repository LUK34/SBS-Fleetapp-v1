package kw.kng.fleetapp.security.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kw.kng.fleetapp.security.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> 
{
	@Query(
	        value = "SELECT * FROM role WHERE id NOT IN (SELECT role_id FROM user_role WHERE user_id = ?1)", 
	        nativeQuery = true
	)
	List<Role> getUserNotRoles(Integer userId);

}
/*
 1. We are using native query to query the databse to fine the list fo roles not assigned to the user.
 2. The roles that are not assigned to the user are stored in a collection framework of List with parameter userid
 
 */