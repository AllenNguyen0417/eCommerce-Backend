package com.ecommerce.ecommerce.repository.marketplace;

import com.ecommerce.ecommerce.model.marketplace.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
