package com.example.projectwebautocenterbukin.services.serviceImpl;

import com.example.projectwebautocenterbukin.dtos.BrandDto;
import com.example.projectwebautocenterbukin.dtos.ModelDto;
import com.example.projectwebautocenterbukin.models.Brand;
import com.example.projectwebautocenterbukin.models.Model;
import com.example.projectwebautocenterbukin.repositories.ModelRepository;
import com.example.projectwebautocenterbukin.services.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService<UUID> {

    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ModelDto> getAllModels() {
        return modelRepository.findAll().stream().map(models -> modelMapper.map(models, ModelDto.class)).collect(Collectors.toList());
    }

    @Override
    public ModelDto getModelById(UUID modelId) {
        return modelMapper.map(modelRepository.findById(modelId), ModelDto.class);
    }

    @Override
    public ModelDto addNewModel(ModelDto modelDto) {
        modelDto.setId(UUID.randomUUID());
        return  modelMapper.map(modelRepository.save(modelMapper.map(modelDto, Model.class)), ModelDto.class);
    }

    @Override
    public ModelDto updateModelName(UUID modelId, ModelDto modelDto) {
        // Optional - для случаев когда метод может вернуть пустое значение
        Optional<Model> modelOptional = modelRepository.findById(modelId);
        if (modelOptional.isPresent()) {
            Model existingModel = modelOptional.get();
            existingModel.setName(modelDto.getName());

            Model updatedModel = modelRepository.save(existingModel);

            return modelMapper.map(updatedModel, ModelDto.class);
        }
        return null;
    }

    @Override
    public void deleteModel(UUID modelId) {
        modelRepository.deleteById(modelId);
    }
}
