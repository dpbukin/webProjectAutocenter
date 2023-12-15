package com.example.projectwebautocenterbukin.controllers.webControllers;

import com.example.projectwebautocenterbukin.services.UserRoleService;
import com.example.projectwebautocenterbukin.services.UserService;
import com.example.projectwebautocenterbukin.services.dtos.UserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String showAllUser(Model model){
        model.addAttribute("userInfos", userService.getAllUsers());
        return "users-all";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("availableRole", userService.showRole());
        return "user-add";
    }
    @ModelAttribute("userModel")
    public UserDto initUser() {
        return new UserDto();
    }

    @PostMapping("/add")
    public String addUser(@Valid UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", userDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",
                    bindingResult);
            return "redirect:/users/add";
        }

        userService.addUser(userDto);

        return "redirect:/";
    }

    @GetMapping("/deactivate_user/{username}")
    public String deactivateUser(@PathVariable String username) {
        userService.deactivateUser(username);
        return "redirect:/users/all";
    }
}

