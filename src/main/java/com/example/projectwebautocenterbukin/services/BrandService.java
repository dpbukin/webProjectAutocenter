package com.example.projectwebautocenterbukin.services;

import com.example.projectwebautocenterbukin.services.dtos.BrandDto;

import java.util.List;

public interface BrandService<ID> {
    List<BrandDto> getAllBrands();
    BrandDto getBrandById(ID brandId);
    BrandDto addNewBrand(BrandDto brandDto);
    BrandDto updateBrand(ID brandId, BrandDto brandDto);
    void deleteBrand(ID brandId);


}
