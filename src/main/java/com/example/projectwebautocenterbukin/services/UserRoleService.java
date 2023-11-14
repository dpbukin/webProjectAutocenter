package com.example.projectwebautocenterbukin.services;

import com.example.projectwebautocenterbukin.services.dtos.UserRoleDto;

import java.util.List;

public interface UserRoleService<ID>{
    List<UserRoleDto> getAllUserRoles();
    UserRoleDto getUserRoleById(ID userRoleId);
    void addUserRole(UserRoleDto userRoleDto);
    void deleteUserRole(ID userRoleId);
}
