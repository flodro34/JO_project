//package com.fdr.jo_project.controllers;
//
//import com.fdr.jo_project.entities.User;
//import com.fdr.jo_project.repositories.UserRepository;
//
//import com.fdr.jo_project.services.UserService;
//import com.fdr.jo_project.util.JwtTokenUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("auth")
//public class AuthController {
//
//
////    @Autowired
////    AuthenticationManager authenticationManager;
////
////    @Autowired
////    JwtUtils jwtUtils;
////    @Autowired
////    private UserRepository userRepository;
////    @Autowired
////    PasswordEncoder encoder;
////    @Autowired
////    UserService userService;
////
////    @RequestMapping(value = "/signin", method = RequestMethod.POST)
////    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
////        Authentication authentication = authenticationManager.authenticate(
////                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
////        SecurityContextHolder.getContext().setAuthentication(authentication);
////
////        String jwt = jwtUtils.generateJwtToken(authentication);
////        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
////
////        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername()));
////
////    }
////
////    @PostMapping("/signup")
////    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest){
////        if(userService.findUser(signUpRequest.getUsername())){
////            return ResponseEntity
////                    .badRequest()
////                    .body(new MessageResponse("Error: Username is already taken"));
////        }
////
////        User user = new User(signUpRequest.getUsername(),
////                encoder.encode(signUpRequest.getPassword()));
////        userService.create(user);
////        userRepository.save(user);
////        return ResponseEntity.ok(new MessageResponse("User registered successufully!"));
////    }
//
////}
//@Autowired
//private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @RequestMapping(value = "/Authorization", method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws Exception {
//
//        authenticate(loginRequest.getUsername(), loginRequest.getPassword());
//
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
//
//        final String token = jwtTokenUtil.generateToken(userDetails.getUsername());
//
//        // Update the user's tokenUser field
//        User user = userRepository.findByUsername(loginRequest.getUsername());
//        user.setTokenUser(token);
//
//        userService.save(user);
//
//        return ResponseEntity.ok(new JwtResponse(token, loginRequest.getUsername()));
//    }
//
//    private void authenticate(String username, String password) throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//    }
//}
//
