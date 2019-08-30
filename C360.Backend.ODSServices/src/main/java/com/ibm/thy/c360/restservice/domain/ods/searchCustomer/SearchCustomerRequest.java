package com.ibm.thy.c360.restservice.domain.ods.searchCustomer;

public class SearchCustomerRequest {

	private Integer id;
	private String name;
	private String surname;
	private String tckn;
	private String tccNumber;
	private String passportNumber;
	private String TelephoneNumber;
	private String email;
	private String tkNumber; //MnS number
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the tckn
	 */
	public String getTckn() {
		return tckn;
	}
	/**
	 * @param tckn the tckn to set
	 */
	public void setTckn(String tckn) {
		this.tckn = tckn;
	}
	/**
	 * @return the tccNumber
	 */
	public String getTccNumber() {
		return tccNumber;
	}
	/**
	 * @param tccNumber the tccNumber to set
	 */
	public void setTccNumber(String tccNumber) {
		this.tccNumber = tccNumber;
	}
	/**
	 * @return the passportNumber
	 */
	public String getPassportNumber() {
		return passportNumber;
	}
	/**
	 * @param passportNumber the passportNumber to set
	 */
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	/**
	 * @return the telephoneNumber
	 */
	public String getTelephoneNumber() {
		return TelephoneNumber;
	}
	/**
	 * @param telephoneNumber the telephoneNumber to set
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		TelephoneNumber = telephoneNumber;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the tkNumber
	 */
	public String getTkNumber() {
		return tkNumber;
	}
	/**
	 * @param tkNumber the tkNumber to set
	 */
	public void setTkNumber(String tkNumber) {
		this.tkNumber = tkNumber;
	}
	
	

}
