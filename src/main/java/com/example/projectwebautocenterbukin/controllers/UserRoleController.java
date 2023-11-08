package com.example.projectwebautocenterbukin.controllers;

import com.example.projectwebautocenterbukin.services.UserRoleService;
import com.example.projectwebautocenterbukin.services.dtos.UserRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/userrole")
public class UserRoleController {
    private UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping("/all")
    List<UserRoleDto> getAllUserRole(){
        return userRoleService.getAllUserRoles();
    }
    @GetMapping("/{id}")
    UserRoleDto getUserRoleById(@PathVariable UUID id){
        return userRoleService.getUserRoleById(id);
    }
    @PostMapping("/add")
    UserRoleDto addUserRole(@RequestBody UserRoleDto userRoleDto){
        return userRoleService.addUserRole(userRoleDto);}
    @DeleteMapping("/delete/{id}")
    String deleteUserRole(@PathVariable UUID id){
        userRoleService.deleteUserRole(id);
        return "Client with id = " + id + " was deleted";}
    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    //    @PutMapping("/{id}/{role}")
//    UserRoleDto updateUserRoleName(@PathVariable UUID id, @PathVariable Role role){
//        return userRoleService.updateUserRoleName(id, role);
//    }

}
