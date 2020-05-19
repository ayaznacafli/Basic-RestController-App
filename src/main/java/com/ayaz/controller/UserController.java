package com.ayaz.controller;

import com.ayaz.model.User;
import com.ayaz.service.UserService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
public class UserController {

    private Logger logger = LoggerFactory.getLogger("UserManagmerApp");
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable(name = "id") String id) {
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public ResponseEntity<Object> addUser(User user) {
        userService.addUser(user);
        URI path = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(path).build();
    }

    @PostMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable(name = "id") String id) {
        return userService.deleteUser(id);
    }

}
