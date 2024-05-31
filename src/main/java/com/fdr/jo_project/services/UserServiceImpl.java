package com.fdr.jo_project.services;

import com.fdr.jo_project.dto.UserDTO;
import com.fdr.jo_project.entities.User;
import com.fdr.jo_project.repositories.UserRepository;
import com.fdr.jo_project.util.CustomTokenUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;


    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO saveUser(UserDTO u) {

        return convertEntityToDTO(userRepository.save(convertDTOToEntity(u)));
    }
    @Override
    public UserDTO updateUser(UserDTO u) {

        return convertEntityToDTO(userRepository.save(convertDTOToEntity(u)));
    }

    @Override
    public User saveWithToken(User user){
        String token = CustomTokenUtil.generateCustomToken();
        user.setTokenUser(token);
        return userRepository.save(user);

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
    public User authenticate(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }



//    @Override
//    public User registerUser(RegistrationRequest request) {
//        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());
//        if(optionalUser.isPresent())
//            throw new EmailAlreadyExistsException("Email déjà utilisé !");
//        User newUser = new User();
//        newUser.setFirstname(request.getFirstname());
//        newUser.setEmail(request.getEmail());
//
//        newUser.setPassword(   bCryptPasswordEncoder.encode(request.getPassword()) );
//        newUser.setEnabled(false);
//        newUser.setAdmin(false);
//
//        userRepository.save(newUser);
//
//        return  userRepository.save(newUser);
//    }

    @Override
    public void sendEmailUser(User u, String code) {

    }

    @Override
    public User validateToken(String code) {
        return null;
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
