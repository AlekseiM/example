package com.minkin.Contacts.model;

public class Contact {

	private String name;
	private String surName;
	private String login;
	private String email;
	private String phoneNumber;

	public Contact() {

	}

	public Contact(String[] data) {

		this.name = data[0];
		this.surName = data[1];
		this.login = data[2];
		this.email = data[3];
		this.phoneNumber = data[4];

	}

	public Contact(String name, String surName, String login, String email, String phoneNumber) {
		super();
		this.name = name;
		this.surName = surName;
		this.login = login;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", surName=" + surName + ", login=" + login + ", email=" + email + ", phoneNumber="
				+ phoneNumber + "]";
	}

}
