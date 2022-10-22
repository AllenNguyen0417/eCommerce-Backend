package com.ecommerce.ecommerce.service.marketplace;

import com.ecommerce.ecommerce.model.marketplace.Address;
import com.ecommerce.ecommerce.model.marketplace.User;
import com.ecommerce.ecommerce.repository.marketplace.AddressRepository;
import com.ecommerce.ecommerce.repository.marketplace.UserRepository;
import com.ecommerce.ecommerce.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Address> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return addresses;
    }

    @Override
    public Address getAddressById(Integer addressId) {
        Address address = addressRepository.findByAddressId(addressId);
        return address;
    }

    @Override
    public Status createAddress(Address address) {
        List<User> users = userRepository.findAll();
        List<Integer> userIds = new ArrayList<>();
        for (User user: users) {
            userIds.add(user.getUserId());
        }
        if (!userIds.contains(address.getUserId())) {
            return Status.USER_ID_NOT_EXISTS;
        }
        addressRepository.save(address);
        return Status.SUCCESS;
    }

    @Override
    public Status updateAddress(Address address) {
        Address addr = addressRepository.findByAddressId(address.getAddressId());
        List<User> users = userRepository.findAll();
        List<Integer> userIds = new ArrayList<>();

        for (User user: users) {
            userIds.add(user.getUserId());
        }

        if (addr == null) {
            return Status.ADDRESS_NOT_FOUND;
        }
        if (!userIds.contains(address.getUserId())) {
            return Status.USER_ID_NOT_EXISTS;
        }
        if(address.getUserId() != null) {
            addr.setUserId(address.getUserId());
            addressRepository.save(addr);
        }
        if(address.getRecipientName() != null) {
            addr.setRecipientName(address.getRecipientName());
            addressRepository.save(addr);
        }
        if(address.getStreet() != null) {
            addr.setStreet(address.getStreet());
            addressRepository.save(addr);
        }
        if(address.getCity() != null) {
            addr.setCity(address.getCity());
            addressRepository.save(addr);
        }
        if(address.getState() != null) {
            addr.setState(address.getState());
            addressRepository.save(addr);
        }
        if(address.getZip() != null) {
            addr.setZip(address.getZip());
            addressRepository.save(addr);
        }

        return Status.SUCCESS;
    }

    @Override
    public Status deleteAddress(Address address) {
        Address addr = addressRepository.findByAddressId(address.getAddressId());
        if (addr == null) {
            return Status.ADDRESS_NOT_FOUND;
        }
        addressRepository.delete(addr);
        return Status.SUCCESS;
    }
}
