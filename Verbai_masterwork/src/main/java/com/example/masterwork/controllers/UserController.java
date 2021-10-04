package com.example.masterwork.controllers;

import com.example.masterwork.entities.User;
import com.example.masterwork.exceptions.ResourceNotFoundException;
import com.example.masterwork.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User save = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @GetMapping
    public ResponseEntity<List<User>> listAllUser() {
        List<User> users = userService.allData();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable long userId) {
        User byId = userService.findById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable long userId, @RequestBody User user) {
        if(user.getId()!=userId){
            throw new UnsupportedOperationException("The given and the stored ID is different!");
        }
        userService.update(user, userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUserById(@PathVariable long userId) {
        System.out.println(userId);
        User byId = userService.findById(userId);
        if(byId == null){
            throw new UnsupportedOperationException("The given ID is not found in our database!");
        }
        userService.deleteById(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
