package com.minkin.Certificate.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = ("PASSPORT"))
public class Passport implements Serializable {

	private static final long serialVersionUID = -2977499185403687157L;

	private Integer id;
	private LastName lastName;
	private FirstName firstName;
	private MiddleName middleName;
	private Number number;
	private Series series;
	private DateIssue dateIssue;
	private CertificateRegistration certificateRegistration;

	public Passport() {

	}

	public Passport(Integer id, LastName lastName, FirstName firstName, MiddleName middleName, Number number,
			Series series, DateIssue dateIssue) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.number = number;
		this.series = series;
		this.dateIssue = dateIssue;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PASSPORT_ID", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	public LastName getLastName() {
		return lastName;
	}

	public void setLastName(LastName lastName) {
		this.lastName = lastName;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	public FirstName getFirstName() {
		return firstName;
	}

	public void setFirstName(FirstName firstName) {
		this.firstName = firstName;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	public MiddleName getMiddleName() {
		return middleName;
	}

	public void setMiddleName(MiddleName middleName) {
		this.middleName = middleName;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	public Number getNumber() {
		return number;
	}

	public void setNumber(Number number) {
		this.number = number;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	public DateIssue getDateIssue() {
		return dateIssue;
	}

	public void setDateIssue(DateIssue dateIssue) {
		this.dateIssue = dateIssue;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CERTIFICATE_REGISTRATION_ID")
	public CertificateRegistration getCertificateRegistration() {
		return certificateRegistration;
	}

	public void setCertificateRegistration(CertificateRegistration certificateRegistration) {
		this.certificateRegistration = certificateRegistration;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", LastName=" + lastName + ", FirstName=" + firstName + ", MiddleName="
				+ middleName + ", Number=" + number + ", Series=" + series + ", DateIssue=" + dateIssue + "]";
	}

}
