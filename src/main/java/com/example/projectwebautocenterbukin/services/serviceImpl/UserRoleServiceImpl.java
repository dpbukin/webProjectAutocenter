package com.example.projectwebautocenterbukin.services.serviceImpl;

import com.example.projectwebautocenterbukin.services.dtos.UserRoleDto;
import com.example.projectwebautocenterbukin.models.UserRole;
import com.example.projectwebautocenterbukin.repositories.UserRoleRepository;
import com.example.projectwebautocenterbukin.services.UserRoleService;
import com.example.projectwebautocenterbukin.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.validation.ConstraintViolation;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService<UUID> {

    private UserRoleRepository userRoleRepository;

    private final ValidationUtil validationUtil;
    private ModelMapper modelMapper;
    @Autowired
    public UserRoleServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserRoleDto> getAllUserRoles() {
        return userRoleRepository.findAll().stream().map(userRole -> modelMapper.map(userRole, UserRoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserRoleDto getUserRoleById(UUID userRoleId) {
        return modelMapper.map(userRoleRepository.findById(userRoleId), UserRoleDto.class);
    }

    @Override
    public void addUserRole(UserRoleDto userRoleDto) {
        userRoleDto.setId(UUID.randomUUID());

        if (!validationUtil.isValid(userRoleDto)) {
            validationUtil
                    .violations(userRoleDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }

        UserRole userRole = modelMapper.map(userRoleDto, UserRole.class);
        UserRole savedUserRole = userRoleRepository.save(userRole);
        modelMapper.map(savedUserRole, UserRoleDto.class);
    }


    @Override
    public void deleteUserRole(UUID userRoleId) {
        userRoleRepository.deleteById(userRoleId);
    }

    @Autowired
    public void setUserRoleRepository(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }
}
