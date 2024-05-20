package com.fdr.jo_project.services;

import com.fdr.jo_project.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User saveUser(User u);
    User updateUser(User u);
    void deleteUser(User u);
    void deleteUserById(Long id);
    User getUser (Long id);
    List<User> getAllUsers();

    boolean isValidTokenUser(String tokenUser);
}
