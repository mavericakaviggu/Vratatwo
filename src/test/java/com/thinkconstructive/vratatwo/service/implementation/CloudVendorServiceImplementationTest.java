package com.thinkconstructive.vratatwo.service.implementation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.thinkconstructive.vratatwo.model.CloudVendor;
import com.thinkconstructive.vratatwo.repository.CloudVendorRepository;
import com.thinkconstructive.vratatwo.service.CloudVendorService;

@Service
public class CloudVendorServiceImplementationTest{

    @Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorService cloudVendorService;
    AutoCloseable autoCloseable;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorServiceImplementation(cloudVendorRepository);
        cloudVendor = new CloudVendor("Amazon","USA","1234");
        
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);        
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("success");     
    }
    //    @Override
    // public String createCloudVendor(CloudVendor cloudVendor) {
    //     cloudVendorRepository.save(cloudVendor);
    //     return "success";}

    @Test
    void testUpdateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);        
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("success");     
    }
    // @Override
    // public String updateCloudVendor(CloudVendor cloudVendor) {
    //     cloudVendorRepository.save(cloudVendor);
    //     return null;
    // }

    @Test
    void testGetCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        
        when(cloudVendorRepository.findById(1)).thenReturn(Optional.ofNullable(cloudVendor));
        assertThat(cloudVendorService.getCloudVendor(1).getVendorName()).isEqualTo(cloudVendor.getVendorName());  
    }
    // @Override
    // public CloudVendor getCloudVendor(String cloudVendorId) {
    //     if (cloudVendorRepository.findById(cloudVendorId).isEmpty())
    //         throw new CloudVendorNotFoundException("Requested cloud vendor doesnt exist");
    //     return cloudVendorRepository.findById(cloudVendorId)
    //             .orElseThrow(() -> new NoSuchElementException("No cloudvendor found with ID " + cloudVendorId));}

    // @Test
    // void testGetByVendorName() {
    //     mock(CloudVendor.class);
    //     mock(CloudVendorRepository.class);
        
    //     when(cloudVendorRepository.findByVendorName("Amazon")).thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));
    //     assertThat(cloudVendorService.getByVendorName("Amazon").get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());  
    // }
    //GetVendorByName which we have not implemented in service layer yet

    @Test
    void testGetAllCloudVendors() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        
        when(cloudVendorRepository.findAll()).thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));
        assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorPhonenumber()).isEqualTo(cloudVendor.getVendorPhonenumber());  
    }
    // @Override
    // public List<CloudVendor> getAllCloudVendors() {
    //     return cloudVendorRepository.findAll();
    // }

    
    @Test
    void testDeleteCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class,Mockito.CALLS_REAL_METHODS);
        
        doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository).deleteById(any());
        assertThat(cloudVendorService.deleteCloudVendor(1)).isEqualTo("success");     
    }
    // // @Override
    // public String deleteCloudVendor(String cloudVendorId) {
    //     cloudVendorRepository.deleteById(cloudVendorId);
    //     return "success";
    // }

}
