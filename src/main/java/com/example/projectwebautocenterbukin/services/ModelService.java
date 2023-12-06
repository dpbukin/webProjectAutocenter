package com.example.projectwebautocenterbukin.services;

import com.example.projectwebautocenterbukin.services.dtos.BrandDto;
import com.example.projectwebautocenterbukin.services.dtos.ModelDto;
import com.example.projectwebautocenterbukin.services.dto_views.ShowModelVM;

import java.util.List;

public interface ModelService {

    List<ShowModelVM> getAllModels();
    void addNewModel(ModelDto modelDto);
    ModelDto modelDetails(String modelName);
    List<BrandDto> showBrand();
}
