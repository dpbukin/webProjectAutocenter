package com.example.projectwebautocenterbukin.services;

import com.example.projectwebautocenterbukin.models.Brand;
import com.example.projectwebautocenterbukin.services.dtos.BrandDto;
import com.example.projectwebautocenterbukin.services.dto_views.ShowBrandVM;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    List<ShowBrandVM> getAllBrands();
    void addNewBrand(BrandDto brandDto);
    ShowBrandVM brandDetails(String brandName);

    ShowBrandVM getBrandById(String id);
}
