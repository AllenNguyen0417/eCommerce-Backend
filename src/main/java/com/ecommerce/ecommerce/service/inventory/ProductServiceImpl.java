package com.ecommerce.ecommerce.service.inventory;

import com.ecommerce.ecommerce.model.inventory.Product;
import com.ecommerce.ecommerce.repository.inventory.ProductRepository;
import com.ecommerce.ecommerce.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Status createProduct(Product newProduct) {
        List<Product> products = productRepository.findAll();
        String newUpc = newProduct.getUpc();
        for(Product product: products) {
            if (newUpc.equals(product.getUpc())) {
                return Status.PRODUCT_ALREADY_EXISTS;
            }
        }
        productRepository.save(newProduct);
        return Status.SUCCESS;
    }

//    @Override
//    public Status updateProduct(Product product) {
//        List<Product> products = productRepository.findAll();
//        for (Product prod : products) {
//
//            if (prod.getUpc().equals(product.getUpc())) {
//                productRepository.save(product);
//                return Status.SUCCESS;
//            }
//        }
//        return Status.PRODUCT_NOT_FOUND;
//    }
    @Override
    public Status updateProduct(Product product) {
        Product prod = productRepository.findByUpc(product.getUpc());
        if (prod == null) {
            return Status.PRODUCT_NOT_FOUND;
        }
        if (product.getProductName() != null) {
            prod.setProductName(product.getProductName());
            productRepository.save(prod);
        }
        if (product.getBrand() != null) {
            prod.setBrand(product.getBrand());
            productRepository.save(prod);
        }
        if (product.getCategory() != null) {
            prod.setCategory(product.getCategory());
            productRepository.save(prod);
        }
        if (product.getProductDescription() != null) {
            prod.setProductDescription(product.getProductDescription());
            productRepository.save(prod);
        }
        if (product.getPricePerUnit() != null) {
            prod.setPricePerUnit(product.getPricePerUnit());
            productRepository.save(prod);
        }
        if (product.getImageUrl() != null) {
            prod.setImageUrl(product.getImageUrl());
            productRepository.save(prod);
        }
        if (product.getAvailableStock() != null) {
            prod.setAvailableStock(product.getAvailableStock());
            productRepository.save(prod);
        }
        if (product.getReservedStock() != null) {
            prod.setReservedStock(product.getReservedStock());
            productRepository.save(prod);
        }
        if (product.getShippedStock() != null) {
            prod.setShippedStock(product.getShippedStock());
            productRepository.save(prod);
        }
        return Status.SUCCESS;
    }


    @Override
    public Status deleteProduct(Product product) {
        Product prod = productRepository.findByUpc(product.getUpc());
        if (prod == null) {
            return Status.PRODUCT_NOT_FOUND;
        }
        productRepository.delete(prod);
        return Status.SUCCESS;
    }
}
