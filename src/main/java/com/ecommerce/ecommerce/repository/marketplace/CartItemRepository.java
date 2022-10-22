package com.ecommerce.ecommerce.repository.marketplace;

import com.ecommerce.ecommerce.model.marketplace.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository <CartItem, Integer>{
    public CartItem findByCartItemId(Integer cartItemId);
}
