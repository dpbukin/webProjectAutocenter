package com.example.projectwebautocenterbukin.services;

import com.example.projectwebautocenterbukin.services.dtos.UserDto;
import com.example.projectwebautocenterbukin.views.UserViewModel;

import java.util.List;

public interface UserService<ID> {
    List<UserViewModel> getAllUsers();
    UserViewModel getUserById(ID userId);
    void addUser(UserDto userDto);
    void updateUserPassword(ID userId, String password);
    void deleteUser(ID userId);
    void deactivateUser(ID userId);
}
