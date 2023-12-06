package com.example.projectwebautocenterbukin.services.serviceImpl;

import com.example.projectwebautocenterbukin.repositories.BrandRepository;
import com.example.projectwebautocenterbukin.services.dtos.BrandDto;
import com.example.projectwebautocenterbukin.services.dtos.ModelDto;
import com.example.projectwebautocenterbukin.models.Model;
import com.example.projectwebautocenterbukin.repositories.ModelRepository;
import com.example.projectwebautocenterbukin.services.ModelService;
import com.example.projectwebautocenterbukin.utils.ValidationUtil;
import com.example.projectwebautocenterbukin.services.dto_views.ShowModelVM;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.validation.ConstraintViolation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {
    private ModelRepository modelRepository;
    private BrandRepository brandRepository;
    private final ValidationUtil validationUtil;
    private ModelMapper modelMapper;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ShowModelVM> getAllModels() {
        return modelRepository.findAll().stream().map(models -> modelMapper.map(models, ShowModelVM.class)).collect(Collectors.toList());
    }

    @Override
    public void addNewModel(ModelDto modelDto) {
        if (!validationUtil.isValid(modelDto)) {
            validationUtil
                    .violations(modelDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }

        Model model = modelMapper.map(modelDto, Model.class);
        model.setBrand(brandRepository.findByName(modelDto.getBrand()).orElseThrow());
        model.setCreated(LocalDateTime.now());
        model.setModified(LocalDateTime.now());

        modelRepository.saveAndFlush(model);
    }

    @Override
    public ModelDto modelDetails(String modelName) {
        return modelMapper.map(modelRepository.findByName(modelName).orElseThrow(), ModelDto.class);
    }

    @Override
    public List<BrandDto> showBrand() {
        return brandRepository.findAll().stream().map(brand -> modelMapper.map(brand, BrandDto.class)).collect(Collectors.toList());
    }

//    @Override
//    public void updateModelName(UUID modelId, String name) {
//        Optional<Model> modelOptional = modelRepository.findById(modelId);
//        if (modelOptional.isPresent()) {
//            Model existingModel = modelOptional.get();
//            existingModel.setName(name);
//
//            if (!validationUtil.isValid(existingModel)) {
//                validationUtil
//                        .violations(existingModel)
//                        .stream()
//                        .map(ConstraintViolation::getMessage)
//                        .forEach(System.out::println);
//
//                throw new IllegalArgumentException("Illegal arguments!");
//            }
//
//            Model updatedModel = modelRepository.save(existingModel);
//            modelMapper.map(updatedModel, ModelDto.class);
//        }
//    }

//    @Override
//    public void deleteModel(UUID modelId) {
//        modelRepository.deleteById(modelId);
//    }
}
