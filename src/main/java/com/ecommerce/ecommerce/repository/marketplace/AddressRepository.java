package com.ecommerce.ecommerce.repository.marketplace;

import com.ecommerce.ecommerce.model.marketplace.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    public Address findByAddressId(Integer addressId);
}
