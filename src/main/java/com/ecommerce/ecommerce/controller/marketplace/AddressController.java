package com.ecommerce.ecommerce.controller.marketplace;

import com.ecommerce.ecommerce.model.marketplace.Address;
import com.ecommerce.ecommerce.service.marketplace.AddressService;
import com.ecommerce.ecommerce.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/marketplace")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("/addresses")
    ResponseEntity<List<Address>> getAllAddress() {
        List<Address> addresses = addressService.getAllAddresses();
        if (addresses.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(addresses);
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @GetMapping("/address/{addressId}")
    ResponseEntity<Address> getAddressById(@PathVariable Integer addressId) {
        Address address = addressService.getAddressById(addressId);
        if(address == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(address);
        }
    }

    @PostMapping("/createaddress")
    ResponseEntity<String> createAddress(@RequestBody Address address) {
        Status stt = addressService.createAddress(address);
        if(stt == Status.SUCCESS) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Address create successfully!");
        }
        else if (stt == Status.USER_ID_NOT_EXISTS) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User ID not exists");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/updateaddress")
    ResponseEntity<String> updateAddress(@RequestBody Address address) {
        Status stt = addressService.updateAddress(address);
        if(stt == Status.SUCCESS) {
            return ResponseEntity.status(HttpStatus.OK).body("Address Update Successfully!");
        }
        else if (stt == Status.PRODUCT_NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Address Not Found!");
        }
        else if (stt == Status.USER_ID_NOT_EXISTS) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User ID not exists!");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/deleteaddress")
    ResponseEntity<String> deleteAddress(@RequestBody Address address) {
        Status stt = addressService.deleteAddress(address);
        if(stt == Status.SUCCESS) {
            return ResponseEntity.status(HttpStatus.OK).body("Address delete successfully!");
        }
        else if (stt == Status.ADDRESS_NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Address not found!");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
