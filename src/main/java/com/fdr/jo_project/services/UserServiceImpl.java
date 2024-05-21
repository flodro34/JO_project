package com.fdr.jo_project.services;

import com.fdr.jo_project.dto.TicketDTO;
import com.fdr.jo_project.dto.UserDTO;
import com.fdr.jo_project.entities.Ticket;
import com.fdr.jo_project.entities.User;
import com.fdr.jo_project.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDTO saveUser(UserDTO u) {

        return convertEntityToDTO(userRepository.save(convertDTOToEntity(u)));
    }
    @Override
    public UserDTO updateUser(UserDTO u) {

        return convertEntityToDTO(userRepository.save(convertDTOToEntity(u)));
    }

    @Override
    public UserDTO getUser(Long id) {

        return convertEntityToDTO(userRepository.findById(id).get());
    }
    @Override
    public List<UserDTO> getAllUsers() {

        return userRepository.findAll().stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
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
    public boolean isValidTokenUser(String tokenUser) {
        return false;
    }

    @Override
    public UserDTO convertEntityToDTO(User user) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        return userDTO;
    }

    @Override
    public User convertDTOToEntity(UserDTO userDTO) {
        User user = new User();
        user = modelMapper.map(userDTO, User.class);
        return user;
    }
}
