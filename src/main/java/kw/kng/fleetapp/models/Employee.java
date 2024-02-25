package kw.kng.fleetapp.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee extends Person
{
	@ManyToOne
	@JoinColumn(name="employeetypeid", insertable=false, updatable=false)
	private EmployeeType employeetype;
	private Integer employeetypeid;
	
	private String photo;
	private String username;
	
	@ManyToOne
	@JoinColumn(name="jobtitleid", insertable=false, updatable=false)
	private JobTitle jobtitle;
	private Integer jobtitleid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date hiredate;
	
	
}
