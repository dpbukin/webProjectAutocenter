package com.example.projectwebautocenterbukin.services;

import com.example.projectwebautocenterbukin.services.dtos.ModelDto;
import com.example.projectwebautocenterbukin.views.ModelViewModel;

import java.util.List;

public interface ModelService<ID> {
    List<ModelViewModel> getAllModels();
    ModelViewModel getModelById(ID modelId);
    void addNewModel(ModelDto modelDto);
    void updateModelName(ID modelId, String name);
    void deleteModel(ID modelId);
}
