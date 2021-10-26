package com.revature.foodinstagram.controllers;


import com.revature.foodinstagram.beans.User;
import com.revature.foodinstagram.repositories.UserRepo;
import com.revature.foodinstagram.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserServices userServices;

    @Autowired
    public UserController(UserServices userServices){
        this.userServices = userServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userServices.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Integer id){
        return userServices.getUserById(id);
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    public User addUser(@RequestBody User user) {
        return userServices.addUser(user);
    }

    @PutMapping(path="/{id}")
    public void updateUser(@PathVariable("id") int id, @RequestBody User user) {
        if (id == user.getId()) {
            userServices.updateUser(user);// this save method is coming from the JpaRepository -> it is like Hibernate's saveOrUpdate();
        }
    }

    @DeleteMapping(path="/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userServices.deleteUser(id);
    }

}