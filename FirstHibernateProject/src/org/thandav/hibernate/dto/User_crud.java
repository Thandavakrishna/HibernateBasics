package org.thandav.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
public class User_crud {

	@Id @GeneratedValue
	private int userId;
	
	private String userName;
	
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
}
