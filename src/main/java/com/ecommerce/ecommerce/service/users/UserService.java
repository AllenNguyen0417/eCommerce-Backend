package com.ecommerce.ecommerce.service.users;

import com.ecommerce.ecommerce.status.Status;
import com.ecommerce.ecommerce.model.users.User;

public interface UserService {
    Status register(User user);
    Status login(User user);

}
