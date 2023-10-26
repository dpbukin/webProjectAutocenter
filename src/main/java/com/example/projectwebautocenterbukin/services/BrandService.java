package com.example.projectwebautocenterbukin.services;

import com.example.projectwebautocenterbukin.dtos.BrandDto;
import com.example.projectwebautocenterbukin.models.Brand;

import java.util.List;

public interface BrandService<ID> {
    List<BrandDto> getAllBrands();
    BrandDto getBrandById(ID brandId);
    BrandDto addNewBrand(BrandDto brandDto);
    BrandDto updateBrand(ID brandId, BrandDto brandDto);
    void deleteBrand(ID brandId);


}
