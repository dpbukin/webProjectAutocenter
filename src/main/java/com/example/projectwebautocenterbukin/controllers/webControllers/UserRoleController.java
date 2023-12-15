package com.example.projectwebautocenterbukin.controllers.webControllers;

import com.example.projectwebautocenterbukin.services.UserRoleService;
import com.example.projectwebautocenterbukin.services.dtos.UserDto;
import com.example.projectwebautocenterbukin.services.dtos.UserRoleDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequestMapping("/userRoles")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping("/all")
    public String showAllUserRole(Model model){
        model.addAttribute("userRoleInfos", userRoleService.getAllUserRoles());
        return "userRoles-all";
    }
    @GetMapping("/add")
    public String addUserRole() {
        return "userRole-add";
    }
    @ModelAttribute("userRoleModel")
    public UserRoleDto initUserRole() {
        return new UserRoleDto();
    }
    @PostMapping("/add")
    public String addUserRole(@Valid UserRoleDto userRoleDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRoleModel", userRoleDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRoleModel",
                    bindingResult);
            return "redirect:/userRoles/add";
        }

        userRoleService.addUserRole(userRoleDto);

        return "redirect:/";
    }
}
