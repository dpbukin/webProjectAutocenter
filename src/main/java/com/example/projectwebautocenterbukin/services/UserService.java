package com.example.projectwebautocenterbukin.services;

import com.example.projectwebautocenterbukin.dtos.UserDto;

import java.util.List;

public interface UserService<ID> {
    List<UserDto> getAllUsers();
    UserDto getUserById(ID userId);
    UserDto addUser(UserDto userDto);
    UserDto updateUser(ID userId, UserDto userDto);
    void deleteUser(ID userId);

//    void deactivateUser(ID userId);
}
