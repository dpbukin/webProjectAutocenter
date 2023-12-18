package com.example.projectwebautocenterbukin.controllers.webControllers;

import com.example.projectwebautocenterbukin.services.UserRoleService;
import com.example.projectwebautocenterbukin.services.UserService;
import com.example.projectwebautocenterbukin.services.dtos.UserDto;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {
    private static final Logger LOG = LogManager.getLogger(Controller.class);
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String showAllUser(Principal principal, Model model){
        LOG.log(Level.INFO, "Show all users for " + principal.getName());
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
    public String addUser(@Valid UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Principal principal){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", userDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",
                    bindingResult);
            return "redirect:/users/add";
        }

        userService.addUser(userDto);

        LOG.log(Level.INFO, "Add new user for " + principal.getName());

        return "redirect:/";
    }

    @GetMapping("/deactivate_user/{username}")
    public String deactivateUser(@PathVariable String username, Principal principal) {
        LOG.log(Level.INFO, "Deactivated the user for " + principal.getName());
        userService.deactivateUser(username);
        return "redirect:/users/all";
    }
}

