package com.thinkconstructive.vratatwo.service.implementation;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkconstructive.vratatwo.exception.CloudVendorNotFoundException;
import com.thinkconstructive.vratatwo.model.CloudVendor;
import com.thinkconstructive.vratatwo.repository.CloudVendorRepository;
import com.thinkconstructive.vratatwo.service.CloudVendorService;

@Service
public class CloudVendorServiceImplementation implements CloudVendorService{

	@Autowired
	private CloudVendorRepository cloudVendorRepository;

	//below is the code for constructor injection
	// CloudVendorRepository cloudVendorRepository;	
	// public CloudVendorServiceImplementation(CloudVendorRepository cloudVendorRepository) {
	// 	super();
	// 	this.cloudVendorRepository = cloudVendorRepository;
	// }

	@Override
	public String createCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "success";
	}

	@Override
	public List<CloudVendor> createCloudVendors(List<CloudVendor> cloudVendors) {
		return cloudVendorRepository.saveAll(cloudVendors);
	}

	public String update(CloudVendor cloudVendor){
		CloudVendor existingProduct=cloudVendorRepository.findById(cloudVendor.getVendorId()).orElse(null);
		existingProduct.setVendorName(cloudVendor.getVendorName());
		existingProduct.setVendorAddress(cloudVendor.getVendorAddress());
		existingProduct.setVendorPhonenumber(cloudVendor.getVendorPhonenumber());
		cloudVendorRepository.save(existingProduct);
		return "success";
	}

	@Override
	public String deleteCloudVendor(Integer cloudVendorId) {
		cloudVendorRepository.deleteById(cloudVendorId);
		return "success";
	}
	
	//adding get() as it returns optional
	@Override
	public CloudVendor getCloudVendor(Integer cloudVendorId) {
		if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
			throw new CloudVendorNotFoundException("Requested cloud vendor does not exist");
		return cloudVendorRepository.findById(cloudVendorId).orElseThrow(() -> new NoSuchElementException("No cloudvendor found with ID " + cloudVendorId));	
	}

	public CloudVendor getCloudVendorName(String name){
		return cloudVendorRepository.findByVendorName(name);
	}

	@Override
	public List<CloudVendor> getAllCloudVendors() {
		
		return cloudVendorRepository.findAll();
	}

}
