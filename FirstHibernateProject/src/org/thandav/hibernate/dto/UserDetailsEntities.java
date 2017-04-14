package org.thandav.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;

@Entity
public class UserDetailsEntities {

	@Id @GeneratedValue
	private int userId;
	private String userName;
	
/*	@OneToOne
	@JoinColumn(name="vehicleId")*/
	/*@OneToMany(cascade={CascadeType.ALL})*/
/*	@JoinTable(name="USER_VEHICLE", joinColumns= @JoinColumn(name="User_id"),
				inverseJoinColumns = @JoinColumn(name="Vehicle_id"))*/
	@OneToMany(mappedBy="user")
	private Collection<VehicleMappings> vehicle = new ArrayList<VehicleMappings>();
	/*private Vehicle vehicle;*/

	
	public Collection<VehicleMappings> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<VehicleMappings> vehicle) {
		this.vehicle = vehicle;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		/*return userName + " from getter method";*/
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
/*	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}*/

}
