package org.thandav.hibernate.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
/*@DiscriminatorValue("Car")*/
public class FourWheeler extends Vehicle {
	
	private String Steeringwheel;

	public String getSteeringwheel() {
		return Steeringwheel;
	}

	public void setSteeringwheel(String steeringwheel) {
		Steeringwheel = steeringwheel;
	}

}
