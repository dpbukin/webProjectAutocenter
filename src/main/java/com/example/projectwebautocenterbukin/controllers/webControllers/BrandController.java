package com.example.projectwebautocenterbukin.controllers.webControllers;

import com.example.projectwebautocenterbukin.services.BrandService;
import com.example.projectwebautocenterbukin.services.dtos.BrandDto;
import com.example.projectwebautocenterbukin.services.dtos.UserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }
    @GetMapping("/all")
    public String showAllBrands(Model model){
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
    public String addBrand(@Valid BrandDto brandDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("brandModel", brandDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.brandModel",
                    bindingResult);
            return "redirect:/brands/add";
        }

        brandService.addNewBrand(brandDto);

        return "redirect:/";
    }



}
