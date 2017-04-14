package org.thandav.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="UserBasic.byId", query="from UserBasic where userId = ?")
@NamedNativeQuery(name="UserBasic.byName", query="select * from User_Basic where userName = ?",resultClass=UserBasic.class)
@Table(name="User_Basic")
public class UserBasic {

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
		return userName;
	}
	

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "UserBasic [userId=" + userId + ", userName=" + userName + "]";
	}
	
}
