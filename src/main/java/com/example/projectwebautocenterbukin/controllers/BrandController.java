package com.example.projectwebautocenterbukin.controllers;

import com.example.projectwebautocenterbukin.services.BrandService;
import com.example.projectwebautocenterbukin.services.dtos.BrandDto;
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
    List<BrandDto> getAllBrand(){
        return brandService.getAllBrands();
    }
    @GetMapping("/{id}")
    BrandDto getBrand(@PathVariable UUID id){
        return brandService.getBrandById(id);
    }
    @PostMapping("/add")
    BrandDto addNewBrand(@RequestBody BrandDto brandDto){
        return brandService.addNewBrand(brandDto);
    }
    @DeleteMapping("/delete/{id}")
    String deleteBrand(@PathVariable UUID id){
        brandService.getBrandById(id);
        return "Brand with id = " + id + " was deleted";}
    @PutMapping("/{id}/{name}")
    BrandDto updateBrandName(@PathVariable UUID id, @PathVariable String name){
        return brandService.updateBrandName(id, name);}

}
