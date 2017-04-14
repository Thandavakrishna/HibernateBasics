package org.thandav.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class VehicleMappings {
	
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private UserDetailsEntities user;
	
	
	public UserDetailsEntities getUser() {
		return user;
	}
	public void setUser(UserDetailsEntities user) {
		this.user = user;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	

}
