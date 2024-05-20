package com.fdr.jo_project.controllers;

import com.fdr.jo_project.entities.Ticket;
import com.fdr.jo_project.entities.User;
import com.fdr.jo_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    //Méthode pour test
    @RequestMapping(method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }
}
