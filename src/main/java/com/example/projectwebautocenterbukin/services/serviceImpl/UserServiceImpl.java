package com.example.projectwebautocenterbukin.services.serviceImpl;

import com.example.projectwebautocenterbukin.services.dtos.UserDto;
import com.example.projectwebautocenterbukin.models.User;
import com.example.projectwebautocenterbukin.repositories.UserRepository;
import com.example.projectwebautocenterbukin.services.UserService;
import com.example.projectwebautocenterbukin.utils.ValidationUtil;
import com.example.projectwebautocenterbukin.views.UserViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.validation.ConstraintViolation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService<UUID> {

    private UserRepository userRepository;

    private final ValidationUtil validationUtil;
    private ModelMapper modelMapper;
    @Autowired
    public UserServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserViewModel> getAllUsers() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public UserViewModel getUserById(UUID userId) {
        return modelMapper.map(userRepository.findById(userId), UserViewModel.class);
    }

    @Override
    public void addUser(UserDto userDto) {
        userDto.setId(UUID.randomUUID());

        if (!validationUtil.isValid(userDto)) {
            validationUtil
                    .violations(userDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }

        User user = modelMapper.map(userDto, User.class);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public void updateUserPassword(UUID userId, String password) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setPassword(password);

            if (!validationUtil.isValid(existingUser)) {
                validationUtil
                        .violations(existingUser)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);

                throw new IllegalArgumentException("Illegal arguments!");
            }

            User updatedUser = userRepository.save(existingUser);
            modelMapper.map(updatedUser, UserDto.class);
        }
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

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}


