package com.example.projectwebautocenterbukin.controllers;

import com.example.projectwebautocenterbukin.services.BrandService;
import com.example.projectwebautocenterbukin.services.dtos.BrandDto;
import com.example.projectwebautocenterbukin.views.BrandViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/brand")
public class BrandController {
    private BrandService brandService;

    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }
    @GetMapping("/all")
    List<BrandViewModel> getAllBrand(){
        return brandService.getAllBrands();
    }
    @GetMapping("/{id}")
    BrandViewModel getBrand(@PathVariable UUID id){
        return brandService.getBrandById(id);
    }
    @PostMapping("/add")
    void addNewBrand(@RequestBody BrandDto brandDto){
        brandService.addNewBrand(brandDto);
    }
    @DeleteMapping("/delete/{id}")
    String deleteBrand(@PathVariable UUID id){
        brandService.getBrandById(id);
        return "Brand with id = " + id + " was deleted";}
    @PutMapping("/{id}/{name}")
    void updateBrandName(@PathVariable UUID id, @PathVariable String name){
        brandService.updateBrandName(id, name);}

}
