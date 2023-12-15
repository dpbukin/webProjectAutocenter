package com.example.projectwebautocenterbukin.services.serviceImpl;

import com.example.projectwebautocenterbukin.models.User;
import com.example.projectwebautocenterbukin.repositories.UserRepository;
import com.example.projectwebautocenterbukin.repositories.UserRoleRepository;
import com.example.projectwebautocenterbukin.services.UserService;
import com.example.projectwebautocenterbukin.services.dtos.UserDto;
import com.example.projectwebautocenterbukin.services.dtos.UserRoleDto;
import com.example.projectwebautocenterbukin.utils.ValidationUtil;
import com.example.projectwebautocenterbukin.services.dto_views.ShowUserVM;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.validation.ConstraintViolation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private final ValidationUtil validationUtil;
    private ModelMapper modelMapper;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ShowUserVM> getAllUsers() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user, ShowUserVM.class)).collect(Collectors.toList());
    }
    @Override
    public void addUser(UserDto userDto) {
            User user = modelMapper.map(userDto, User.class);
            user.setRole(userRoleRepository.findByRole(userDto.getRole()).orElseThrow());
            user.setIsActive(true);
            user.setCreated(LocalDateTime.now());
            user.setModified(LocalDateTime.now());
            userRepository.saveAndFlush(user);
    }

    @Override
    public ShowUserVM userDetails(String userName) {
        return modelMapper.map(userRepository.findByUsername(userName).orElse(null), ShowUserVM.class);
    }

    @Override
    public List<UserRoleDto> showRole() {
        return userRoleRepository.findAll().stream().map(userRole -> modelMapper.map(userRole, UserRoleDto.class)).collect(Collectors.toList());
    }
    @Override
    public void deactivateUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            User deactUser = user.get();
            deactUser.setIsActive(false);
            deactUser.setModified(LocalDateTime.now());
            userRepository.save(deactUser);
        }
    }

//    @Override
//    public void updateUserPassword(UUID userId, String password) {
//        Optional<User> userOptional = userRepository.findById(userId);
//        if (userOptional.isPresent()) {
//            User existingUser = userOptional.get();
//            existingUser.setPassword(password);
//
//            if (!validationUtil.isValid(existingUser)) {
//                validationUtil
//                        .violations(existingUser)
//                        .stream()
//                        .map(ConstraintViolation::getMessage)
//                        .forEach(System.out::println);
//
//                throw new IllegalArgumentException("Illegal arguments!");
//            }
//
//            User updatedUser = userRepository.save(existingUser);
//            modelMapper.map(updatedUser, UserDto.class);
//        }
//    }

//    @Override
//    public void deleteUser(UUID userId) {
//        userRepository.deleteById(userId);
//    }
}


