package com.example.projectwebautocenterbukin.services;

import com.example.projectwebautocenterbukin.services.dto_views.ShowUserVM;
import com.example.projectwebautocenterbukin.services.dtos.UserDto;
import com.example.projectwebautocenterbukin.services.dtos.UserRoleDto;

import java.util.List;

public interface UserService {
    List<ShowUserVM> getAllUsers();
    void addUser(UserDto addUserVM);
    ShowUserVM userDetails(String userName);

    List<UserRoleDto> showRole();

//    void updateUserPassword(ID userId, String password);
//    void deleteUser(ID userId);

    void deactivateUser(String username);
}
