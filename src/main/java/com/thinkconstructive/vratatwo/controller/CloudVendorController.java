package com.thinkconstructive.vratatwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 
import com.thinkconstructive.vratatwo.model.CloudVendor;
import com.thinkconstructive.vratatwo.response.ResponseHandler;
import com.thinkconstructive.vratatwo.service.CloudVendorService;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

	// The CloudVendorController constructor is annotated with @Autowired.
	@Autowired
	private CloudVendorService cloudVendorService;
	
	 
	//This constructor injection is used to inject the CloudVendorService dependency into the controller.
	// public CloudVendorController(CloudVendorService cloudVendorService) {
	// 	super();
	// 	this.cloudVendorService = cloudVendorService;
	// }
	
	@PostMapping
	public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {	
		cloudVendorService.createCloudVendor(cloudVendor);
		return "cloud vendor created successfully";		
	}

	@PostMapping("/createAll")
	public String createCloudVendors(@RequestBody List<CloudVendor> cloudVendors){
		return cloudVendorService.createCloudVendors(cloudVendors).toString();
	}

	//code for custon response(compare with the above one)
	@GetMapping("/vendorId/{vendorID}")
	public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorID") Integer vendorID) {
		return ResponseHandler.customResponse("Requested Vendor details", HttpStatus.OK, cloudVendorService.getCloudVendor(vendorID));
	}

	@GetMapping("/vendorName/{vendorName}")
	public CloudVendor getCloudVendorName(@PathVariable("vendorName") String vendorName) {
		return cloudVendorService.getCloudVendorName(vendorName);
	}	
	
	@GetMapping()
	public List<CloudVendor> getAllCloudVendorDetails() {
		return cloudVendorService.getAllCloudVendors();			
	}
	
	@PutMapping("/update")
	public String update(@RequestBody CloudVendor cloudVendor){
		cloudVendorService.update(cloudVendor);
		return "cloudVendor updated successfully"; 
	}
	
	@DeleteMapping("{vendorId}")
	public String deleteCloudVendorDetails(@PathVariable("vendorId") Integer vendorId) {		
		cloudVendorService.deleteCloudVendor(vendorId);
		return "cloud vendor deleted successfully";
	}
	
}
