package kw.kng.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kw.kng.fleetapp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> 
{
	User findByUsername(String username);
	User findByFirstnameAndLastname(String firstname, String lastname);

}
