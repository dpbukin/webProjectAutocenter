package com.example.projectwebautocenterbukin.services;

import com.example.projectwebautocenterbukin.services.dtos.BrandDto;
import com.example.projectwebautocenterbukin.views.BrandViewModel;

import java.util.List;

public interface BrandService<ID> {
    List<BrandViewModel> getAllBrands();
    BrandViewModel getBrandById(ID brandId);
    void addNewBrand(BrandDto brandDto);
    void updateBrandName(ID brandId, String name);
    void deleteBrand(ID brandId);


}
