package kw.kng.fleetapp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class VehicleMovement
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="vehicleid", insertable=false, updatable=false)
	private Vehicle vehicle;
	private Integer vehicleid;
	
	@ManyToOne
	@JoinColumn(name="locationid1", insertable=false, updatable=false)
	private Location location1;
	private Integer locationid1;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date date1;
	
	@ManyToOne
	@JoinColumn(name="locationid2", insertable=false, updatable=false)
	private Location location2;
	private Integer locationid2;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")		
	private Date date2;

	private String remarks;
	
	
	
}
