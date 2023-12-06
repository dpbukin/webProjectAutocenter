//package com.example.projectwebautocenterbukin.controllers.postmanControllers;
//
//import com.example.projectwebautocenterbukin.services.UserRoleService;
//import com.example.projectwebautocenterbukin.services.dtos.UserRoleDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/userrole")
//public class UserRoleController {
//    private UserRoleService userRoleService;
//
//    @Autowired
//    public UserRoleController(UserRoleService userRoleService) {
//        this.userRoleService = userRoleService;
//    }
//
//    @GetMapping("/all")
//    List<UserRoleDto> getAllUserRole(){
//        return userRoleService.getAllUserRoles();
//    }
//    @GetMapping("/{id}")
//    UserRoleDto getUserRoleById(@PathVariable UUID id){
//        return userRoleService.getUserRoleById(id);
//    }
//    @PostMapping("/add")
//    void addUserRole(@RequestBody UserRoleDto userRoleDto){
//        userRoleService.addUserRole(userRoleDto);}
//    @DeleteMapping("/delete/{id}")
//    String deleteUserRole(@PathVariable UUID id){
//        userRoleService.deleteUserRole(id);
//        return "Client with id = " + id + " was deleted";}
//    @Autowired
//    public void setUserRoleService(UserRoleService userRoleService) {
//        this.userRoleService = userRoleService;
//    }
//
//
//}
