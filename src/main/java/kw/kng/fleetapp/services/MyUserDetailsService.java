package kw.kng.fleetapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.User;
import kw.kng.fleetapp.models.UserPrincipal;
import kw.kng.fleetapp.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService
{
	@Autowired
	UserRepository ur;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User user= ur.findByUsername(username);
		if(user == null)
		{
			throw new UsernameNotFoundException("User not Found!!!");
		}
		
		return new UserPrincipal(user);
	}

}
