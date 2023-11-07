package com.example.projectwebautocenterbukin.services;

import com.example.projectwebautocenterbukin.services.dtos.UserRoleDto;

import java.util.List;

public interface UserRoleService<ID>{
    List<UserRoleDto> getAllUserRoles();
    UserRoleDto getUserRoleById(ID userRoleId);
    UserRoleDto addUserRole(UserRoleDto userRoleDto);
//    UserRoleDto updateUserRole(ID userRoleId, UserRoleDto UserRoleDto);
    void deleteUserRole(ID userRoleId);
}
