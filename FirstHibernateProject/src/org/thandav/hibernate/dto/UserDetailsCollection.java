package org.thandav.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "user_details")
public class UserDetailsCollection {

	@Id @GeneratedValue
	private int userId;
	
	private String userName;
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS", 
				joinColumns = @JoinColumn(name="USERID"))
	/*@GenericGenerator(name = "hilo-gen", strategy = "sequence")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type="long"))*/
	/*private Set<Address> listOfAddresses = new HashSet<>();	Commented to use a collection that can have 
	 * indexes or primary key for generated table as well*/
	private Collection<Address> listOfAddresses = new ArrayList<Address>();

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
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

}
