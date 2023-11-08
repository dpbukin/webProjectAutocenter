package com.example.projectwebautocenterbukin.controllers;

import com.example.projectwebautocenterbukin.services.UserService;
import com.example.projectwebautocenterbukin.services.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/all")
    List<UserDto> getAllUsers(){
        return userService.getAllUsers();}
    @GetMapping("/{id}")
    UserDto getUserById(@PathVariable UUID id){
        return userService.getUserById(id);}
    @PostMapping("/add")
    UserDto addNewOffer(@RequestBody UserDto userDto){
        return userService.addUser(userDto);}
    @DeleteMapping("/delete/{id}")
    String deleteOffer(@PathVariable UUID id){
        userService.deleteUser(id);
        return "User with id = " + id + " was deleted";}

    @PostMapping("/deactivateuser/{id}")
    String deactivateUser(@PathVariable UUID id) {
        userService.deactivateUser(id);
        return "User with id = " + id + " was deactivate";
    }

    @PutMapping("/{id}/{password}")
    UserDto updateUserPassword(@PathVariable UUID id, @PathVariable String password){
        return userService.updateUserPassword(id, password);
    }

}

