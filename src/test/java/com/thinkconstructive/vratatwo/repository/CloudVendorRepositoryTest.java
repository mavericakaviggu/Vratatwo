package com.thinkconstructive.vratatwo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.thinkconstructive.vratatwo.model.CloudVendor;

@DataJpaTest
public class CloudVendorRepositoryTest {
	
	@Autowired 
	private CloudVendorRepository cloudVendorRepository;
	CloudVendor cloudVendor;
			
	@BeforeEach
	void setUp() {
		cloudVendor = new CloudVendor("Amazon","USA","1234");
		cloudVendorRepository.save(cloudVendor);
	}
	
	@AfterEach
	void tearDown() {
		cloudVendor = null;
		cloudVendorRepository.deleteAll();
	}
	
	//test case SUCCESS	
	@Test
	void testFindByVendorName_Found(){
		CloudVendor cloudVendorList = cloudVendorRepository.findByVendorName("Amazon");
		assertThat(cloudVendorList.getVendorId()).isEqualTo(cloudVendor.getVendorId());
		assertThat(cloudVendorList.getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
	}
	
	//test case FAILURE
	@Test
	void testFindByVendorName_NotFound() {
		CloudVendor cloudVendorList = cloudVendorRepository.findByVendorName("vignesh");
		assertThat(cloudVendorList==null).isTrue();
		
	}
	

}
