package com.thinkconstructive.vratatwo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkconstructive.vratatwo.model.CloudVendor;

//first arguement is the entity class and second one is ID of the entiy class
public interface CloudVendorRepository extends JpaRepository <CloudVendor, Integer>{
	
	//always remember that name of the method should be camel case of the name defined in entity class
	List<CloudVendor> findByVendorName(String vendorName);
	CloudVendor findByVendorPhonenumber(String vendorPhonenumber);
	

}
