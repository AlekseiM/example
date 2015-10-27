package com.minkin.Certificate.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = ("CERTIFICATE_REGISTRATION"))
public class CertificateRegistration implements Serializable {

	private static final long serialVersionUID = 1256022887887388162L;

	private Integer id;
	private RegistrationDate registrationDate;
	private OrganizationRegistration organizationRegistration;
	private Set<Passport> passports = new HashSet<Passport>(0);

	public CertificateRegistration() {

	}

	public CertificateRegistration(Integer id, RegistrationDate registrationDate,
			OrganizationRegistration organizationRegistr, Set<Passport> passports) {
		super();
		this.id = id;
		this.registrationDate = registrationDate;
		this.organizationRegistration = organizationRegistr;
		this.passports = passports;
	}

	public CertificateRegistration(Set<Passport> passports) {
		this.passports = passports;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CERTIFICATE_REGISTRATION_ID", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "certificateRegistration")
	public RegistrationDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(RegistrationDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "certificateRegistration")
	public OrganizationRegistration getOrganizRegistr() {
		return organizationRegistration;
	}

	public void setOrganizRegistr(OrganizationRegistration organizationRegistration) {
		this.organizationRegistration = organizationRegistration;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "certificateRegistration")
	public Set<Passport> getPassports() {
		return passports;
	}

	public void setPassports(Set<Passport> passports) {
		this.passports = passports;
	}

	@Override
	public String toString() {
		return "CertificateRegistration [id=" + id + ", RegistrationDate=" + registrationDate + ", OrganizationRegistration="
				+ organizationRegistration + ", passports=" + passports + "]";
	}

}
