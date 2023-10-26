package com.example.projectwebautocenterbukin.services;

import com.example.projectwebautocenterbukin.dtos.ModelDto;

import java.util.List;

public interface ModelService<ID> {
    List<ModelDto> getAllModels();
    ModelDto getModelById(ID modelId);
    ModelDto addNewModel(ModelDto modelDto);
    ModelDto updateModelName(ID modelId, ModelDto modelDto);
    void deleteModel(ID modelId);
}
