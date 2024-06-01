package com.thinkconstructive.vratatwo.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.thinkconstructive.vratatwo.model.CloudVendor;
import com.thinkconstructive.vratatwo.service.CloudVendorService;

@WebMvcTest(CloudVendorController.class)
public class CloudVendorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CloudVendorService cloudVendorService;
    CloudVendor cloudVendorOne;
    CloudVendor cloudVendorTwo;
    List<CloudVendor> cloudVendorList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cloudVendorOne = new CloudVendor("Amazon", "USA", "1234");
        cloudVendorTwo = new CloudVendor("Google", "UK", "5678");
        cloudVendorList.add(cloudVendorOne);
        cloudVendorList.add(cloudVendorTwo);
    }

    @AfterEach
    void tearDown() {

    }

    // @PostMapping
    // public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    // {

    // cloudVendorService.createCloudVendor(cloudVendor);
    // return "cloud vendor created successfully";

    // }

    // @GetMapping("{vendorID}")
    // public CloudVendor getCloudVendorDetails(@PathVariable("vendorID") String
    // vendorID) {
    // return cloudVendorService.getCloudVendor(vendorID);
    // }

    // code for custon response(compare with the above one)

    @Test
    void testGetCloudVendorDetails() throws Exception {
        when(cloudVendorService.getCloudVendor(1)).thenReturn(cloudVendorOne);
        this.mockMvc.perform(get("/cloudvendor/1")).andDo(print()).andExpect(status().isOk());
    }
    // @GetMapping("{vendorID}")
    // public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorID")
    // String vendorID) {
    // return ResponseHandler.customResponse("Requested Vendor details",
    // HttpStatus.OK,
    // cloudVendorService.getCloudVendor(vendorID));
    // }

    // @GetMapping()
    // public List<CloudVendor> getAllCloudVendorDetails() {
    // return cloudVendorService.getAllCloudVendors();
    // }

    // @PutMapping
    // public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    // {

    // cloudVendorService.updateCloudVendor(cloudVendor);
    // return "cloud vendor updated successfully";
    // }

    // @DeleteMapping("{vendorId}")
    // public String deleteCloudVendorDetails(@PathVariable("vendorId") String
    // vendorId) {

    // cloudVendorService.deleteCloudVendor(vendorId);
    // return "cloud vendor deleted successfully";
    // }

}
