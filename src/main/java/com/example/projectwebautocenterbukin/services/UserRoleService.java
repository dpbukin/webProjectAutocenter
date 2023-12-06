package com.example.projectwebautocenterbukin.services;

import com.example.projectwebautocenterbukin.services.dto_views.ShowUserRoleVM;
import com.example.projectwebautocenterbukin.services.dtos.UserRoleDto;

import java.util.List;

public interface UserRoleService{
    List<UserRoleDto> getAllUserRoles();
    void addUserRole(UserRoleDto userRoleDto);
    ShowUserRoleVM userRoleDetails(String userRole);

//    void deleteUserRole(ID userRoleId);
}
