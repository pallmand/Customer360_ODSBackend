package com.ibm.thy.c360.restservice.domain.ods.searchCustomer;

public class Customer {
	private Integer id;
	private String name;
	private String surname;
	private String tckn;
	private String passportNumber;
	private String mnsNumber;
	private String email;
	private String tkNumber;

	public String getTckn() {
		return tckn;
	}

	public void setTckn(String tckn) {
		this.tckn = tckn;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getMnsNumber() {
		return mnsNumber;
	}

	public void setMnsNumber(String mnsNumber) {
		this.mnsNumber = mnsNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTkNumber() {
		return tkNumber;
	}

	public void setTkNumber(String tkNumber) {
		this.tkNumber = tkNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
