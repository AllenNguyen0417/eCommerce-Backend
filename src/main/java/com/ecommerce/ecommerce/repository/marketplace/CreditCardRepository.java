package com.ecommerce.ecommerce.repository.marketplace;

import com.ecommerce.ecommerce.model.marketplace.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard,Integer> {
    public CreditCard findByCreditCardId(Integer creditCardId);
}
