package com.ecommerce.ecommerce.model.marketplace;

import javax.persistence.*;

@Table(name = "cart_items")
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId;

    private Integer userId;

    private String upc;

    private Integer quantity;

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CartItem(Integer cartItemId, Integer userId, String upc, Integer quantity) {
        this.cartItemId = cartItemId;
        this.userId = userId;
        this.upc = upc;
        this.quantity = quantity;
    }

    public CartItem() {
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId=" + cartItemId +
                ", userId=" + userId +
                ", upc='" + upc + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
