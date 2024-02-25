package kw.kng.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.fleetapp.models.Employee;
import kw.kng.fleetapp.models.User;
import kw.kng.fleetapp.repositories.EmployeeRepository;
import kw.kng.fleetapp.repositories.UserRepository;

@Service
public class EmployeeService
{
	
	@Autowired
	EmployeeRepository empr;
	
	@Autowired
	UserRepository ur;
	
	/*
	 <------------------------------------------ Return List of Employees --------------------------------------------------->
	*/
	public List<Employee> listAllEmployee()
	{
		return empr.findAll();
		
	}
	
	/*
	 <------------------------------------------ Add Employee ->Save button Logic --------------------------------------------------->
	*/
	
	public void saveEmployee(Employee employee)
	{
		empr.save(employee);
	}
	
	/*
	 <------------------------------------------ Edit Employee Icon ->Fetch record by id logic --------------------------------------------------->
	*/
	
	public Optional<Employee> findById(int id)
	{
	return empr.findById(id);
	}
	
	/*
	 <------------------------------------------ Delete Employee Icon ->Delete record by id logic --------------------------------------------------->
	*/ 
	
	public void deleteEmployee(Integer id)
	{
		empr.deleteById(id);
	}

	/*
	 <-------------------------------- Find the employee details of the employee logged in application-------------------------------------->
	*/ 
	public Employee findByUsername(String un) {
		return empr.findByUsername(un);
	}

	/*
	 <------------------------------------Set the Username of the employee where firstname and lastname match--------------------------------->
	 */
	
	public void assignUsername(int id){
		Employee employee = empr.findById(id).orElse(null);
		User user = ur.findByFirstnameAndLastname(
				employee.getFirstname(),
				employee.getLastname());
		employee.setUsername(user.getUsername());
		empr.save(employee);
	}
}


/*
 1. Based on the user that has logged in the application the findByUsername method will go to db and fetch
 the details of the user that has logged in submit the details to Profile Controller
 */