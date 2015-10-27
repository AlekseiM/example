package com.minkin.Certificate.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = ("NUMBER"))
public class Number implements  Model, Serializable, ModelPassport {

	private static final long serialVersionUID = -2527466913417709083L;
	private Integer id;
	private String information;
	private Passport passport;

	public Number() {

	}

	public Number(Integer id, String information) {
		super();
		this.id = id;
		this.information = information;
	}

	
	public void setId(Integer id) {
		this.id = id;

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {

		return id;
	}

	
	public void setInformation(String information) {
		this.information = information;

	}
	@Column(name = "INFORMATION", length = 40)
	public String getInformation() {

		return information;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PASSPORT_ID")
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Number [id=" + id + ", information=" + information + "]";
	}

}
