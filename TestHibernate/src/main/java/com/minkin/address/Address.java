package com.minkin.address;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name =("ADDRESS"))
public class Address implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String city;
	private String street;
	private String house;
	
	private Set<Resident> residents = new HashSet<Resident>();
	
		public Address() {
		
	}

		public Address(String city, String street, String house, Set<Resident> residents) {
			
			this.city = city;
			this.street = street;
			this.house = house;
			this.residents = residents;
		}

		public Address(Integer id, String city, String street, String house, Set<Resident> residents) {
			
			this.id = id;
			this.city = city;
			this.street = street;
			this.house = house;
			this.residents = residents;
		}
		
        @Id
        @GeneratedValue(strategy = IDENTITY)
        @Column(name = "ID", unique = true, nullable = false)
		public Integer getId() {
			return id;
		}
        
		public void setId(Integer id) {
			this.id = id;
		}
        @Column(name = "CITY", unique = true, nullable = false, length = 20)
		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
        @Column(name = "STREET", unique = true, nullable = false, length = 20)
		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}
        @Column(name ="HOUSE", unique = true, nullable = false, length = 20)
		public String getHouse() {
			return house;
		}

		public void setHouse(String house) {
			this.house = house;
		}
        @OneToMany(fetch = FetchType.LAZY, mappedBy ="address")
        public Set<Resident> getResidents() {
			return this.residents;
		}

		public void setResidents(Set<Resident> residents) {
			this.residents = residents;
		}

		@Override
		public String toString() {
			return "Address [id=" + id + ", city=" + city + ", street=" + street + ", house=" + house + ", residents="
					+ residents + "]";
		}
		
		
		

}
