package kw.kng.fleetapp;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SpringSecurityAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		/*
		 The Authentication object will contain a whole lot of authentication
		  details of the user that has logged in. Currently we are taking only one detail
		  that is the username
		 */
	    String username = authentication.getName();	
		
		return Optional.ofNullable(username).filter(s -> !s.isEmpty());
		/*
		 This will return the username provided that the username is not empty.
		 We use Optional to avoid null pointer exception.
		 */
	}

}

/*
 1.This class will return the current login user.
 2.
 */