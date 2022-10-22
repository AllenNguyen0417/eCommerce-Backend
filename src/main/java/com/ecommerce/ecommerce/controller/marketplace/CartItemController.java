package com.ecommerce.ecommerce.controller.marketplace;

import com.ecommerce.ecommerce.model.marketplace.CartItem;
import com.ecommerce.ecommerce.service.marketplace.CartItemService;
import com.ecommerce.ecommerce.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/marketplace")
public class CartItemController {

    @Autowired
    CartItemService cartItemService;

    @GetMapping("/carts")
    ResponseEntity<List<CartItem>> getCart() {
        List<CartItem> cartItems = cartItemService.getCart();
        if (cartItems.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(cartItems);
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @GetMapping("/cart/{cartItemId}")
    ResponseEntity<CartItem> getCartById(@PathVariable Integer cartItemId) {
        CartItem cartItem = cartItemService.getCartById(cartItemId);
        if (cartItem == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(cartItem);
        }
    }

    @PostMapping("/createcart")
    ResponseEntity<String> createCart(@RequestBody CartItem cartItem) {
        Status stt = cartItemService.createCartItem(cartItem);
        if (stt == Status.SUCCESS) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Cart Create Successfully!");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/updatecart")
    ResponseEntity<String> updateCart(@RequestBody CartItem cartItem) {
        Status stt = cartItemService.updateCartItem(cartItem);
        if (stt == Status.SUCCESS) {
            return ResponseEntity.status(HttpStatus.OK).body("Cart Update Successfully!");
        }
        else if (stt == Status.CART_ITEM_NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cart Item ID Not Found!");
        }
        else if (stt == Status.USER_ID_NOT_EXISTS) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User ID Not Exists!");
        }
        else if (stt == Status.UPC_NOT_EXISTS) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("UPC Not Exists!");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/deletecart")
    public ResponseEntity<String> deleteCart(@RequestBody CartItem cartItem) {
        Status stt = cartItemService.deleteCartItem(cartItem);
        if(stt == Status.SUCCESS) {
            return ResponseEntity.status(HttpStatus.OK).body("Product Delete Successfully!");
        }
        else if (stt == Status.CART_ITEM_NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cart Item ID Not Found!");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
