package com.example.projectwebautocenterbukin.services.serviceImpl;

import com.example.projectwebautocenterbukin.services.dtos.UserDto;
import com.example.projectwebautocenterbukin.models.User;
import com.example.projectwebautocenterbukin.repositories.UserRepository;
import com.example.projectwebautocenterbukin.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService<UUID> {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Autowired


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
    public UserDto updateUserPassword(UUID userId,String password) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setPassword(password);
            User updatedUser = userRepository.save(existingUser);
            return modelMapper.map(updatedUser, UserDto.class);
        }
        return null;
    }

    @Override
    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void deactivateUser(UUID userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User deactUser = user.get();
            deactUser.setIsActive(false);
            deactUser.setModified(LocalDateTime.now());
            userRepository.save(deactUser);
        }
    }
}


