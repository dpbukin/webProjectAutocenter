package com.example.projectwebautocenterbukin.controllers.webControllers;

import com.example.projectwebautocenterbukin.models.Brand;
import com.example.projectwebautocenterbukin.repositories.BrandRepository;
import com.example.projectwebautocenterbukin.services.BrandService;
import com.example.projectwebautocenterbukin.services.ModelService;
import com.example.projectwebautocenterbukin.services.dto_views.ShowBrandVM;
import com.example.projectwebautocenterbukin.services.dtos.BrandDto;
import com.example.projectwebautocenterbukin.services.dtos.ModelDto;
import com.example.projectwebautocenterbukin.services.dtos.UserDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/models")
public class ModelController {
    @Autowired
    private ModelService modelService;
    @Autowired
    private BrandService brandService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/all")
    public String showAllModels(Model model){
        model.addAttribute("modelInfos", modelService.getAllModels());
        return "models-all";
    }

    @GetMapping("/model-details/{model-name}")
    public String modelDetails(@PathVariable("model-name") String modelName, Model model) {
        model.addAttribute("modelDetails", modelService.modelDetails(modelName));
        return "model-details";
    }

    @GetMapping("/add")
    public String addModel(Model model) {
        model.addAttribute("availableBrands", modelService.showBrand());
        return "model-add";
    }

    @ModelAttribute("modelModel")
    public ModelDto initModel() {
        return new ModelDto();
    }
    @PostMapping("/add")
    public String addModel(@Valid ModelDto modelDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("modelModel", modelDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modelModel",
                    bindingResult);
            return "redirect:/models/add";
        }
        modelService.addNewModel(modelDto);

        return "redirect:/";
    }

}
