package com.example.projectwebautocenterbukin.controllers.webControllers;

import com.example.projectwebautocenterbukin.services.BrandService;
import com.example.projectwebautocenterbukin.services.dtos.BrandDto;
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
@RequestMapping("/brands")
public class BrandController {
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @Autowired
    private BrandService brandService;



    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }
    @GetMapping("/all")
    public String showAllBrands(Principal principal, Model model){
        LOG.log(Level.INFO, "Show all brands for " + principal.getName());
        model.addAttribute("brandInfos", brandService.getAllBrands());

        return "brands-all";
    }

    @GetMapping("/add")
    public String addBrand() {
        return "brand-add";
    }

    @ModelAttribute("brandModel")
    public BrandDto initBrand() {
        return new BrandDto();
    }

    @PostMapping("/add")
    public String addBrand(@Valid BrandDto brandDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Principal principal){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("brandModel", brandDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.brandModel",
                    bindingResult);
            return "redirect:/brands/add";
        }

        brandService.addNewBrand(brandDto);

        LOG.log(Level.INFO, "Add new brand for " + principal.getName());

        return "redirect:/";
    }



}
