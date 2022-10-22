package com.ecommerce.ecommerce.service.marketplace;

import com.ecommerce.ecommerce.model.inventory.Product;
import com.ecommerce.ecommerce.model.marketplace.CartItem;
import com.ecommerce.ecommerce.model.marketplace.User;
import com.ecommerce.ecommerce.repository.inventory.ProductRepository;
import com.ecommerce.ecommerce.repository.marketplace.CartItemRepository;
import com.ecommerce.ecommerce.repository.marketplace.UserRepository;
import com.ecommerce.ecommerce.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;


    // Get all cart items
    @Override
    public List<CartItem> getCart() {
        List<CartItem> cartItems = cartItemRepository.findAll();
        return cartItems;
    }

    // Get single cart item
    @Override
    public CartItem getCartById(Integer cartItemId) {
        CartItem cartItem = cartItemRepository.findByCartItemId(cartItemId);
        return cartItem;
    }

    @Override
    public Status createCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
        return Status.SUCCESS;
    }

    @Override
    public Status updateCartItem(CartItem cartItem) {
        CartItem cItem = cartItemRepository.findByCartItemId(cartItem.getCartItemId());
        List<User> users = userRepository.findAll();
        List<Integer> userIds = new ArrayList<>();

        List<Product> products = productRepository.findAll();
        List<String> upcs = new ArrayList<>();

        for (User user: users) {
            userIds.add(user.getUserId());
        }

        for(Product product : products) {
            upcs.add(product.getUpc());
        }

        if (cItem == null) {
            return Status.CART_ITEM_NOT_FOUND;
        }

        if (!userIds.contains(cartItem.getUserId())) {
            return Status.USER_ID_NOT_EXISTS;
        }

        if(!upcs.contains(cartItem.getUpc())) {
            return Status.UPC_NOT_EXISTS;
        }

        if (cartItem.getUserId() != null) {
            cItem.setUserId(cartItem.getUserId());
            cartItemRepository.save(cItem);
        }
        if (cartItem.getUpc() != null) {
            cItem.setUpc(cartItem.getUpc());
            cartItemRepository.save(cItem);
        }
        if(cartItem.getQuantity() != null) {
            cItem.setQuantity(cartItem.getQuantity());
            cartItemRepository.save(cItem);
        }
        return Status.SUCCESS;
    }

    @Override
    public Status deleteCartItem(CartItem cartItem) {
        CartItem cItem = cartItemRepository.findByCartItemId(cartItem.getCartItemId());
        if (cItem == null) {
            return Status.CART_ITEM_NOT_FOUND;
        }
        cartItemRepository.delete(cItem);
        return Status.SUCCESS;
    }

}
