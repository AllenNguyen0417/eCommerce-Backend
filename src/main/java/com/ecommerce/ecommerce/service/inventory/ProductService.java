package com.ecommerce.ecommerce.service.inventory;

import com.ecommerce.ecommerce.model.inventory.Product;
import com.ecommerce.ecommerce.status.Status;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Status createProduct(Product product);

    Status updateProduct(Product product);

    Status deleteProduct(Product product);


}
