package com.minkin.address;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;





@Entity
@Table (name = ("RESIDENT"))
public class Resident implements Serializable {
	
		
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	private Address address;
	
public Resident() {
		
	}
	
	
	public Resident(String firstName, String lastName, Integer age) {
	
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
}


	public Resident(String firstName, String lastName, Integer age, Address address) {
	
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.address = address;
}


	@Id
	@GeneratedValue (strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "FIRST_NAME", nullable = false, length = 20)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name = "LAST_NAME", nullable = false, length = 20)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name="AGE", nullable = false)
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID", nullable = false)
	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Resident [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
}
