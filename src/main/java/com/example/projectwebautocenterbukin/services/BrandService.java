package com.example.projectwebautocenterbukin.services;

import com.example.projectwebautocenterbukin.services.dtos.BrandDto;

import java.util.List;

public interface BrandService<ID> {
    List<BrandDto> getAllBrands();
    BrandDto getBrandById(ID brandId);
    BrandDto addNewBrand(BrandDto brandDto);
    BrandDto updateBrandName(ID brandId, String name);
    void deleteBrand(ID brandId);


}
