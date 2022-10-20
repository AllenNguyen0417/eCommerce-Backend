package com.ecommerce.ecommerce.controller.users;


import com.ecommerce.ecommerce.status.Status;
import com.ecommerce.ecommerce.model.users.User;
import com.ecommerce.ecommerce.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        Status stt = userService.register(user);
        if (stt == Status.SUCCESS) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully!");
        }
        else if (stt == Status.USER_ALREADY_EXISTS) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exist!");
        }
        else if (stt == Status.EMAIL_ALREADY_EXISTS) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exist!");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        Status stt = userService.login(user);

        if (stt == Status.SUCCESS) {
            return ResponseEntity.status(HttpStatus.OK).body("Login Successfully!");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Your username or password may be incorrect!");
        }
    }

}
