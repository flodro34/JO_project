package com.fdr.jo_project.controllers;

import com.fdr.jo_project.dto.UserDTO;
import com.fdr.jo_project.entities.Ticket;
import com.fdr.jo_project.entities.User;

import com.fdr.jo_project.services.UserService;
//import com.fdr.jo_project.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;

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

//    @PostMapping("/register")
//    public User registerUser(@RequestBody User user) {
//        return userService.saveWithToken(user);
//    }

    @RequestMapping(method = RequestMethod.PUT)
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }

//   @RequestMapping(value ="/register",method = RequestMethod.POST)
//    public ResponseEntity<?> registerUser(@RequestBody User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//
//        // Save the user to the database
//        userService.save(user);
//
//        // Generate token
//        final String token = jwtTokenUtil.generateToken(user.getUsername());
//
//        // Update the user's tokenUser field
//        user.setTokenUser(token);
//       userService.save(user);
//
//        return ResponseEntity.ok(new JwtResponse(token, user.getUsername()));
//    }
}
