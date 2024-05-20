package com.fdr.jo_project.services;

import com.fdr.jo_project.entities.User;
import com.fdr.jo_project.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    @Override
    public User saveUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public User updateUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public void deleteUser(User u) {
        userRepository.delete(u);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean isValidTokenUser(String tokenUser) {
        return false;
    }
}
