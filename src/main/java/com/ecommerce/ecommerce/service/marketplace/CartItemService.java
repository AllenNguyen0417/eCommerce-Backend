package com.ecommerce.ecommerce.service.marketplace;

import com.ecommerce.ecommerce.model.marketplace.CartItem;
import com.ecommerce.ecommerce.status.Status;

import java.util.List;
import java.util.Optional;

public interface CartItemService {
    List<CartItem> getCart();

    CartItem getCartById(Integer cartItemId);

    Status createCartItem(CartItem cartItem);

    Status updateCartItem(CartItem cartItem);

    Status deleteCartItem(CartItem cartItem);
}
