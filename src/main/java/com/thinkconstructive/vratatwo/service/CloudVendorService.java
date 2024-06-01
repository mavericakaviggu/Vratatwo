package com.thinkconstructive.vratatwo.service;

import java.util.List;

import com.thinkconstructive.vratatwo.model.CloudVendor;

public interface CloudVendorService {
	
	public String createCloudVendor(CloudVendor cloudVendor); 
	public String updateCloudVendor(CloudVendor cloudVendor);
	public String deleteCloudVendor(Integer cloudVendorId);
	public CloudVendor getCloudVendor(Integer cloudVendorId);
	public List<CloudVendor> getAllCloudVendors();
	
}
