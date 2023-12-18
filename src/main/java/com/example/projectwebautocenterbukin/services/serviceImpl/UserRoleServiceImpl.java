package com.example.projectwebautocenterbukin.services.serviceImpl;

import com.example.projectwebautocenterbukin.models.enums.Role;
import com.example.projectwebautocenterbukin.services.dto_views.ShowUserRoleVM;
import com.example.projectwebautocenterbukin.services.dtos.UserRoleDto;
import com.example.projectwebautocenterbukin.models.UserRole;
import com.example.projectwebautocenterbukin.repositories.UserRoleRepository;
import com.example.projectwebautocenterbukin.services.UserRoleService;
import com.example.projectwebautocenterbukin.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import jakarta.validation.ConstraintViolation;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleRepository userRoleRepository;
    private final ValidationUtil validationUtil;
    private ModelMapper modelMapper;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.userRoleRepository = userRoleRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addUserRole(UserRoleDto userRoleDto) {
        UserRole userRole = modelMapper.map(userRoleDto, UserRole.class);
        UserRole savedUserRole = userRoleRepository.save(userRole);
        modelMapper.map(savedUserRole, UserRoleDto.class);
    }

    @Override
    public List<UserRoleDto> getAllUserRoles() {
        return userRoleRepository.findAll().stream().map(userRole -> modelMapper.map(userRole, UserRoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public ShowUserRoleVM userRoleDetails(String userRole) {
        return modelMapper.map(userRoleRepository.findByRole(Role.valueOf(userRole)).orElse(null), ShowUserRoleVM.class);
    }



//    @Override
//    public void deleteUserRole(UUID userRoleId) {
//        userRoleRepository.deleteById(userRoleId);
//    }
//
//    @Autowired
//    public void setUserRoleRepository(UserRoleRepository userRoleRepository) {
//        this.userRoleRepository = userRoleRepository;

}
