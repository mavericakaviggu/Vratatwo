package com.thinkconstructive.vratatwo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkconstructive.vratatwo.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository <CloudVendor,String>{
	
	List<CloudVendor> findByVendorName(String vendorName);
	

}
