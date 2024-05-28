package com.fdr.jo_project.controllers;

import com.fdr.jo_project.dto.UserDTO;
import com.fdr.jo_project.entities.Ticket;
import com.fdr.jo_project.entities.User;
import com.fdr.jo_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDTO getUserById(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    //Méthode pour test
    @RequestMapping(method = RequestMethod.POST)
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }
}
