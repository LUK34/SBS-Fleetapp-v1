package kw.kng.fleetapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef="auditorAware")
@SpringBootApplication
public class FleetAppApplication {

	@Bean
	public AuditorAware<String> auditorAware() 
	{
		return new SpringSecurityAuditorAware();
	}
	
	public static void main(String[] args) 
	{
		SpringApplication.run(FleetAppApplication.class, args);
	}

}
