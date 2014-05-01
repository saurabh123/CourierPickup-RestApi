package com.restapi.courier.dto;

public class Address {
	

private String contactName ;


private String companyName ;

private String address1 ;

private String address2 ;

private String country ;

private String city ;

private String state ;

private int zipcode ;

private int phoneNo;

/**
 * @return the contactName
 */
public String getContactName() {
	return contactName;
}

/**
 * @param contactName the contactName to set
 */
public void setContactName(String contactName) {
	this.contactName = contactName;
}

/**
 * @return the companyName
 */
public String getCompanyName() {
	return companyName;
}

/**
 * @param companyName the companyName to set
 */
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

/**
 * @return the address1
 */
public String getAddress1() {
	return address1;
}

/**
 * @param address1 the address1 to set
 */
public void setAddress1(String address1) {
	this.address1 = address1;
}

/**
 * @return the address2
 */
public String getAddress2() {
	return address2;
}

/**
 * @param address2 the address2 to set
 */
public void setAddress2(String address2) {
	this.address2 = address2;
}

/**
 * @return the city
 */
public String getCity() {
	return city;
}

/**
 * @param city the city to set
 */
public void setCity(String city) {
	this.city = city;
}

/**
 * @return the zipcode
 */
public int getZipcode() {
	return zipcode;
}

/**
 * @param zipcode the zipcode to set
 */
public void setZipcode(int zipcode) {
	this.zipcode = zipcode;
}

/**
 * @return the country
 */
public String getCountry() {
	return country;
}

/**
 * @param country the country to set
 */
public void setCountry(String country) {
	this.country = country;
}

/**
 * @return the state
 */
public String getState() {
	return state;
}

/**
 * @param state the state to set
 */
public void setState(String state) {
	this.state = state;
}

/**
 * @return the phoneNo
 */
public int getPhoneNo() {
	return phoneNo;
}

/**
 * @param phoneNo the phoneNo to set
 */
public void setPhoneNo(int phoneNo) {
	this.phoneNo = phoneNo;
}


	
}
