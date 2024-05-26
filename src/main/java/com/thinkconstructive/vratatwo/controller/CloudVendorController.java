package com.thinkconstructive.vratatwo.controller;

import java.util.List;

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


	CloudVendorService cloudVendorService;
	
	// The CloudVendorController constructor is annotated with @Autowired. 
	//This constructor injection is used to inject the CloudVendorService dependency into the controller.
	public CloudVendorController(CloudVendorService cloudVendorService) {
		super();
		this.cloudVendorService = cloudVendorService;
	}
	
	@PostMapping
	public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		
		cloudVendorService.createCloudVendor(cloudVendor);
		return "cloud vendor created successfully";
		
	}

//	@GetMapping("{vendorID}")
//	public CloudVendor getCloudVendorDetails(@PathVariable("vendorID") String vendorID) {
//		return cloudVendorService.getCloudVendor(vendorID);			
//	}
	
	//code for custon response(compare with the above one)
	@GetMapping("{vendorID}")
	public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorID") String vendorID) {
		return ResponseHandler.customResponse("Requested Vendor details", HttpStatus.OK, cloudVendorService.getCloudVendor(vendorID));
	}
	
	
	@GetMapping()
	public List<CloudVendor> getAllCloudVendorDetails() {
		return cloudVendorService.getAllCloudVendors();			
	}
	
	@PutMapping
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		
		cloudVendorService.updateCloudVendor(cloudVendor);
		return "cloud vendor updated successfully";
	}
	
	@DeleteMapping("{vendorId}")
	public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		
		cloudVendorService.deleteCloudVendor(vendorId);
		return "cloud vendor deleted successfully";
	}
	
}
