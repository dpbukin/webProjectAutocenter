package com.example.projectwebautocenterbukin.services.serviceImpl;

import com.example.projectwebautocenterbukin.models.User;
import com.example.projectwebautocenterbukin.models.enums.Role;
import com.example.projectwebautocenterbukin.repositories.UserRepository;
import com.example.projectwebautocenterbukin.repositories.UserRoleRepository;
import com.example.projectwebautocenterbukin.services.dtos.UserRegistrationDto;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, UserRoleRepository userRoleRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserRegistrationDto registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            throw new RuntimeException("passwords.match");
        }

        Optional<User> byUserName = this.userRepository.findByUsername(registrationDTO.getUsername());

        if (byUserName.isPresent()) {
            throw new RuntimeException("username.used");
        }

        var userRole = userRoleRepository.findByRole(Role.USER).orElseThrow();

        User user = modelMapper.map(registrationDTO, User.class);
        user.setRole(userRole);
        user.setIsActive(true);
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        userRepository.saveAndFlush(user);

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        this.userRepository.saveAndFlush(user);
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }
}
