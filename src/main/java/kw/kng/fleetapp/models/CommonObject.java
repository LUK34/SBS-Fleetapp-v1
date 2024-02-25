package kw.kng.fleetapp.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CommonObject extends Auditable<String>
{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private String details;
	
	/*---------------------------------------------------------------------------------------------------------------*/
	//Generate constructors using Fields
	//remove super()
	public CommonObject(Integer id, String description, String details) 
	{
		this.id = id;
		this.description = description;
		this.details = details;
	}
	
	/*---------------------------------------------------------------------------------------------------------------*/
	//Generate constructors from superclass 
	//remove super()
	public CommonObject() 
	{

	}
	/*---------------------------------------------------------------------------------------------------------------*/
	//Generate getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	/*---------------------------------------------------------------------------------------------------------------*/
	//Generate to string method
	@Override
	public String toString()
	{
		return "CommonObject [id=" + id + ", description=" + description + ", details=" + details + "]";
	}
	/*---------------------------------------------------------------------------------------------------------------*/

	
	
}

/*
 1. Note that this is not Entity. This is a superclass that is used to inherit other class hence we use
 @MappedSuperclass


 */