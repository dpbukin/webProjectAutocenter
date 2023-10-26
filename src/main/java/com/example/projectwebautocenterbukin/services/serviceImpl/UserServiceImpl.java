package com.example.projectwebautocenterbukin.services.serviceImpl;

import com.example.projectwebautocenterbukin.dtos.UserDto;
import com.example.projectwebautocenterbukin.models.User;
import com.example.projectwebautocenterbukin.repositories.UserRepository;
import com.example.projectwebautocenterbukin.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService<UUID> {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(UUID userId) {
        return modelMapper.map(userRepository.findById(userId), UserDto.class);
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        userDto.setId(UUID.randomUUID());
        return modelMapper.map(userRepository.save(modelMapper.map(userDto, User.class)), UserDto.class);
    }

    @Override
    public UserDto updateUser(UUID userId, UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();

            existingUser.setUsername(userDto.getUsername());
            existingUser.setPassword(userDto.getPassword());
            existingUser.setFirstName(userDto.getFirstName());
            existingUser.setLastName(userDto.getLastName());
            existingUser.setIsActive(userDto.getIsActive());
            existingUser.setImageUrl(userDto.getImageUrl());

            User updatedUser = userRepository.save(existingUser);

            return modelMapper.map(updatedUser, UserDto.class);
        }
        return null;
    }

    @Override
    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }

//    @Override
//    public void deactivateUser(UUID userId) {
//        userRepository.findById(userId);
//        userRepository.setIsActive(false);
//            // Сохраните изменения в базе данных
//            userRepository.save(user);
//        }

    }

