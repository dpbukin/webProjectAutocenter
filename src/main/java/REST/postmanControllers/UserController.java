//package com.example.projectwebautocenterbukin.controllers.postmanControllers;
//
//import com.example.projectwebautocenterbukin.services.UserService;
//import com.example.projectwebautocenterbukin.services.dtos.UserDto;
//import com.example.projectwebautocenterbukin.views.user.ShowFullUserVM;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import java.util.*;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//    private UserService userService;
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//    @GetMapping("/all")
//    List<ShowFullUserVM> getAllUsers(){
//        return userService.getAllUsers();}
//    @GetMapping("/{id}")
//    ShowFullUserVM getUserById(@PathVariable UUID id){
//        return userService.getUserById(id);}
//    @PostMapping("/add")
//    void addNewOffer(@RequestBody UserDto userDto){
//        userService.addUser(userDto);}
//    @DeleteMapping("/delete/{id}")
//    String deleteOffer(@PathVariable UUID id){
//        userService.deleteUser(id);
//        return "User with id = " + id + " was deleted";}
//
//    @PostMapping("/deactivateuser/{id}")
//    String deactivateUser(@PathVariable UUID id) {
//        userService.deactivateUser(id);
//        return "User with id = " + id + " was deactivate";
//    }
//
//    @PutMapping("/{id}/{password}")
//    void updateUserPassword(@PathVariable UUID id, @PathVariable String password){
//        userService.updateUserPassword(id, password);
//    }
//
//}
//
