package com.thinkconstructive.vratatwo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cloud_vendor_info") 
public class CloudVendor {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vendorId;
	private String vendorName;
	private String vendorAddress;
	private String vendorPhonenumber;	
	
	public CloudVendor() {		
	}
	public CloudVendor(String vendorName, String vendorAddress, String vendorPhonenumber) {
		
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.vendorPhonenumber = vendorPhonenumber;
	}
	
	
	public Integer getVendorId() {
		return vendorId;
	}
	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorPhonenumber() {
		return vendorPhonenumber;
	}
	public void setVendorPhonenumber(String vendorPhonenumber) {
		this.vendorPhonenumber = vendorPhonenumber;
	}

}
