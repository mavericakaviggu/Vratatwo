package com.thinkconstructive.vratatwo.service;

import java.util.List;

import com.thinkconstructive.vratatwo.model.CloudVendor;

public interface CloudVendorService {
	
	public String createCloudVendor(CloudVendor cloudVendor); 
	public List<CloudVendor> createCloudVendors(List<CloudVendor> cloudVendors);
	public CloudVendor getCloudVendor(Integer cloudVendorId);
	public CloudVendor getCloudVendorName(String name);
	public List<CloudVendor> getAllCloudVendors();
	public String update(CloudVendor cloudVendor);
	public String deleteCloudVendor(Integer cloudVendorId);
	
		
}
