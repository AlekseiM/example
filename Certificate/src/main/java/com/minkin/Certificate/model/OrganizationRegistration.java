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
@Table(name = ("ORGANIZATION_REGISTRATION"))
public class OrganizationRegistration implements  Model, Serializable {

	private static final long serialVersionUID = -1592793956000731392L;
	private Integer id;
	private String information;
	private CertificateRegistration certificateRegistration;

	public OrganizationRegistration() {

	}

	public OrganizationRegistration(Integer id, String information) {
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
    @JoinColumn(name = "CERTIFICATE_REGISTRATION_ID")
	public CertificateRegistration getCertificateRegistration() {
		return certificateRegistration;
	}

	public void setCertificateRegistration(CertificateRegistration certificateRegistration) {
		this.certificateRegistration = certificateRegistration;
	}

	@Override
	public String toString() {
		return "OrganizationRegistration [id=" + id + ", information=" + information + "]";
	}

}
