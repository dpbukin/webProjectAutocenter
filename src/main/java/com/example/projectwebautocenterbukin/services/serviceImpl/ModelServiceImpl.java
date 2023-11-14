package com.example.projectwebautocenterbukin.services.serviceImpl;

import com.example.projectwebautocenterbukin.services.dtos.ModelDto;
import com.example.projectwebautocenterbukin.models.Model;
import com.example.projectwebautocenterbukin.repositories.ModelRepository;
import com.example.projectwebautocenterbukin.services.ModelService;
import com.example.projectwebautocenterbukin.utils.ValidationUtil;
import com.example.projectwebautocenterbukin.views.ModelViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.validation.ConstraintViolation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService<UUID> {

    private ModelRepository modelRepository;
    private final ValidationUtil validationUtil;
    private ModelMapper modelMapper;

    @Autowired
    public ModelServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ModelViewModel> getAllModels() {
        return modelRepository.findAll().stream().map(models -> modelMapper.map(models, ModelViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public ModelViewModel getModelById(UUID modelId) {
        return modelMapper.map(modelRepository.findById(modelId), ModelViewModel.class);
    }

    @Override
    public void addNewModel(ModelDto modelDto) {
        modelDto.setId(UUID.randomUUID());

        if (!validationUtil.isValid(modelDto)) {
            validationUtil
                    .violations(modelDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }

        Model model = modelMapper.map(modelDto, Model.class);
        this.modelRepository.saveAndFlush(model);
    }

    @Override
    public void updateModelName(UUID modelId, String name) {
        Optional<Model> modelOptional = modelRepository.findById(modelId);
        if (modelOptional.isPresent()) {
            Model existingModel = modelOptional.get();
            existingModel.setName(name);

            if (!validationUtil.isValid(existingModel)) {
                validationUtil
                        .violations(existingModel)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);

                throw new IllegalArgumentException("Illegal arguments!");
            }

            Model updatedModel = modelRepository.save(existingModel);
            modelMapper.map(updatedModel, ModelDto.class);
        }
    }

    @Override
    public void deleteModel(UUID modelId) {
        modelRepository.deleteById(modelId);
    }

    @Autowired
    public void setModelRepository(ModelRepository modelRepository){
        this.modelRepository = modelRepository;
    }
}
