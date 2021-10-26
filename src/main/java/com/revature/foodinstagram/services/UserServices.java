package com.revature.foodinstagram.services;

import com.revature.foodinstagram.beans.User;
import com.revature.foodinstagram.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.plugin.dom.exception.InvalidAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    private final UserRepo userRepo;

    @Autowired
    public UserServices(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User getByUsername(User user){
        System.out.println(user);
        User u =  userRepo.findByUsername(user.getUsername());
        String username = u.getUsername();
        String password = u.getPassword();
        System.out.println(username + " the username "+ password + " password |" +"after the user Repo " +u);
        if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
            System.out.println("should be true");
            return u;
        }
        else{
            System.out.println("inside else");
            throw new InvalidAccessException("Invalid Credentials");
        }
    }

    public User addUser(User user) {return userRepo.save(user);}

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public void updateUser(User user) {
        userRepo.save(user);
    }

    public User getUserById(Integer user_id){
        Optional<User> u = userRepo.findById(user_id);
        return u.orElse(null);
    }

    public void deleteUser(Integer id){
        userRepo.delete(userRepo.getById(id));
    }

}