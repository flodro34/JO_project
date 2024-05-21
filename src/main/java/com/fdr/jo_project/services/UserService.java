package com.fdr.jo_project.services;

import com.fdr.jo_project.dto.UserDTO;
import com.fdr.jo_project.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);

    UserDTO getUser (Long id);
    List<UserDTO> getAllUsers();

    void deleteUser(User u);
    void deleteUserById(Long id);

    boolean isValidTokenUser(String tokenUser);

    UserDTO convertEntityToDTO(User u);
    User convertDTOToEntity(UserDTO userDTO);
}
