package com.example.projectwebautocenterbukin.services.serviceImpl;

import com.example.projectwebautocenterbukin.services.dtos.UserRoleDto;
import com.example.projectwebautocenterbukin.models.UserRole;
import com.example.projectwebautocenterbukin.repositories.UserRoleRepository;
import com.example.projectwebautocenterbukin.services.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService<UUID> {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserRoleDto> getAllUserRoles() {
        return userRoleRepository.findAll().stream().map(userRole -> modelMapper.map(userRole, UserRoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserRoleDto getUserRoleById(UUID userRoleId) {
        return modelMapper.map(userRoleRepository.findById(userRoleId), UserRoleDto.class);

//        public ModelDto getModelById(UUID modelId) {
//            return modelMapper.map(modelRepository.findById(modelId), ModelDto.class);

    }

    @Override
    public UserRoleDto addUserRole(UserRoleDto userRoleDto) {
        userRoleDto.setId(UUID.randomUUID());
        return modelMapper.map(userRoleRepository.save(modelMapper.map(userRoleDto, UserRole.class)), UserRoleDto.class);
    }

    @Override
    public UserRoleDto updateUserRole(UUID userRoleId, UserRoleDto userRoleDto) {
        Optional<UserRole> userRoleOptional = userRoleRepository.findById(userRoleId);
        if (userRoleOptional.isPresent()) {
            UserRole existingUserRole = userRoleOptional.get();

            existingUserRole.setName(userRoleDto.getName());
            existingUserRole.setRole(userRoleDto.getRole());

            UserRole updatedUserRole = userRoleRepository.save(existingUserRole);

            return modelMapper.map(updatedUserRole, UserRoleDto.class);
        }
        return null;
    }

    @Override
    public void deleteUserRole(UUID userRoleId) {
        userRoleRepository.deleteById(userRoleId);
    }
}
