package com.thinkconstructive.vratatwo.service.implementation;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.thinkconstructive.vratatwo.exception.CloudVendorNotFoundException;
import com.thinkconstructive.vratatwo.model.CloudVendor;
import com.thinkconstructive.vratatwo.repository.CloudVendorRepository;
import com.thinkconstructive.vratatwo.service.CloudVendorService;

@Service
public class CloudVendorServiceImplementation implements CloudVendorService{

	CloudVendorRepository cloudVendorRepository;
	
	
	public CloudVendorServiceImplementation(CloudVendorRepository cloudVendorRepository) {
		super();
		this.cloudVendorRepository = cloudVendorRepository;
	}

	@Override
	public String createCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "success";
		
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return null;
	}

	@Override
	public String deleteCloudVendor(String cloudVendorId) {
		cloudVendorRepository.deleteById(cloudVendorId);
		return "success";
	}
	
	//adding get() as it returns optional

	@Override
	public CloudVendor getCloudVendor(String cloudVendorId) {
		if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
			throw new CloudVendorNotFoundException("Requested cloud vendor doesnt exist");
		return cloudVendorRepository.findById(cloudVendorId).orElseThrow(() -> new NoSuchElementException("No cloudvendor found with ID " + cloudVendorId));
		
	}

	@Override
	public List<CloudVendor> getAllCloudVendors() {
		
		return cloudVendorRepository.findAll();
	}

}
