package com.restapi.courier.dto;

import java.util.Date;

public class Consignment {
	
			
	private int id;

	private String user;

	private int   weight;

	private Date createdDate;

	private String pickupSlot;

	private int packageCount;

	private String type;

	private int pickupAddId;

	private Date scheduledDate;

	private int status;

	private String statusDesc;

	private Address pickupAddress ;
	
	private Address DeliveryAddress;
	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}


	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}


	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}


	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}


	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	/**
	 * @return the pickupSlot
	 */
	public String getPickupSlot() {
		return pickupSlot;
	}


	/**
	 * @param pickupSlot the pickupSlot to set
	 */
	public void setPickupSlot(String pickupSlot) {
		this.pickupSlot = pickupSlot;
	}


	/**
	 * @return the packageCount
	 */
	public int getPackageCount() {
		return packageCount;
	}


	/**
	 * @param packageCount the packageCount to set
	 */
	public void setPackageCount(int packageCount) {
		this.packageCount = packageCount;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * @return the pickupAddId
	 */
	public int getPickupAddId() {
		return pickupAddId;
	}


	/**
	 * @param pickupAddId the pickupAddId to set
	 */
	public void setPickupAddId(int pickupAddId) {
		this.pickupAddId = pickupAddId;
	}


	/**
	 * @return the scheduledDate
	 */
	public Date getScheduledDate() {
		return scheduledDate;
	}


	/**
	 * @param scheduledDate the scheduledDate to set
	 */
	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}


	/**
	 * @return the statusDesc
	 */
	public String getStatusDesc() {
		return statusDesc;
	}


	/**
	 * @param statusDesc the statusDesc to set
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}


	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}


	/**
	 * @return the pickupAddress
	 */
	public Address getPickupAddress() {
		return pickupAddress;
	}


	/**
	 * @param pickupAddress the pickupAddress to set
	 */
	public void setPickupAddress(Address pickupAddress) {
		this.pickupAddress = pickupAddress;
	}


	/**
	 * @return the deliveryAddress
	 */
	public Address getDeliveryAddress() {
		return DeliveryAddress;
	}


	/**
	 * @param deliveryAddress the deliveryAddress to set
	 */
	public void setDeliveryAddress(Address deliveryAddress) {
		DeliveryAddress = deliveryAddress;
	}


	

}
