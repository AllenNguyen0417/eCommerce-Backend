package com.ecommerce.ecommerce.model.inventory;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="products", uniqueConstraints = {
        @UniqueConstraint(columnNames = "upc")
})
public class Product {
    @Id
    @Column(name = "upc", nullable = false)
    private String upc;

    @NotBlank
    private String productName;

    @NotBlank
    private String brand;

    @NotBlank
    private String category;

    @NotBlank
    private String productDescription;

    @NotBlank
    private String pricePerUnit;

    @NotBlank
    private String imageUrl;

    @NotBlank
    private String availableStock;

    @NotBlank
    private String reservedStock;

    @NotBlank
    private String shippedStock;

    public Product() {
    }

    public Product(String upc, String productName, String brand, String category, String productDescription, String pricePerUnit, String imageUrl, String availableStock, String reservedStock, String shippedStock) {
        this.upc = upc;
        this.productName = productName;
        this.brand = brand;
        this.category = category;
        this.productDescription = productDescription;
        this.pricePerUnit = pricePerUnit;
        this.imageUrl = imageUrl;
        this.availableStock = availableStock;
        this.reservedStock = reservedStock;
        this.shippedStock = shippedStock;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(String pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(String availableStock) {
        this.availableStock = availableStock;
    }

    public String getReservedStock() {
        return reservedStock;
    }

    public void setReservedStock(String reservedStock) {
        this.reservedStock = reservedStock;
    }

    public String getShippedStock() {
        return shippedStock;
    }

    public void setShippedStock(String shippedStock) {
        this.shippedStock = shippedStock;
    }
}
