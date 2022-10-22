package com.ecommerce.ecommerce.service.marketplace;

import com.ecommerce.ecommerce.status.Status;
import com.ecommerce.ecommerce.model.marketplace.User;

public interface UserService {
    Status register(User user);
    Status login(User user);

}
