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
		cloudVendor = new CloudVendor("1","Amazon","USA","1234");
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
		List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("Amazon");
		assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
		assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
	}
	
	//test case FAILURE
	@Test
	void testFindByVendorName_NotFound() {
		List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("vignesh");
		assertThat(cloudVendorList.isEmpty()).isTrue();
		
	}
	
	
	
	

}
