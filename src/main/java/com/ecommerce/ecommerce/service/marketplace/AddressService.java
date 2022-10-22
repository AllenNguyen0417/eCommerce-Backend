package com.ecommerce.ecommerce.service.marketplace;

import com.ecommerce.ecommerce.model.marketplace.Address;
import com.ecommerce.ecommerce.status.Status;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();

    Address getAddressById(Integer addressId);

    Status createAddress(Address address);

    Status updateAddress(Address address);

    Status deleteAddress(Address address);
}
