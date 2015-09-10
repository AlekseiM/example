package com.minkin.car.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CAR")
public class Car implements Serializable {

	private static final long serialVersionUID = 5116486051033347802L;

	private Long carId;

	private String brand;
	private Integer releaseYear;
	private Integer cost;
	private Date createdDate;

	public Car() {

	}

	public Car(String brand, Integer releaseYear, Integer cost) {

		this.brand = brand;
		this.releaseYear = releaseYear;
		this.cost = cost;
	}

	public Car(String brand, Integer releaseYear, Integer cost, Date createdDate) {

		this.brand = brand;
		this.releaseYear = releaseYear;
		this.cost = cost;
		this.createdDate = createdDate;
	}

	public Car(Long carId, String brand, Integer releaseYear, Integer cost, Date createdDate) {

		this.carId = carId;
		this.brand = brand;
		this.releaseYear = releaseYear;
		this.cost = cost;
		this.createdDate = createdDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CAR_ID", unique = true, nullable = false, precision = 5, scale = 0)
	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	@Column(name = "BRAND", nullable = false, length = 20)
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "RELEASE_YEAR", nullable = false)
	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Column(name = "COST", nullable = false)
	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", nullable = false, length = 10)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
