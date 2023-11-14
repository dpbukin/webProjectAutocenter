package com.example.projectwebautocenterbukin.services.serviceImpl;

import com.example.projectwebautocenterbukin.services.dtos.BrandDto;
import com.example.projectwebautocenterbukin.models.Brand;
import com.example.projectwebautocenterbukin.services.BrandService;
import com.example.projectwebautocenterbukin.utils.ValidationUtil;
import com.example.projectwebautocenterbukin.views.BrandViewModel;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projectwebautocenterbukin.repositories.BrandRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService<UUID> {

    private BrandRepository brandRepository;

    private final ValidationUtil validationUtil;
    private ModelMapper modelMapper;
    @Autowired
    public BrandServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addNewBrand(BrandDto brandDto) {
        brandDto.setId(UUID.randomUUID());
//        return  modelMapper.map(brandRepository.save(modelMapper.map(brandDto, Brand.class)), BrandDto.class);

        if (!this.validationUtil.isValid(brandDto)) {

            this.validationUtil
                    .violations(brandDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }

        Brand brand = this.modelMapper.map(brandDto, Brand.class);

        this.brandRepository.saveAndFlush(brand);

    }

    @Override
    public void updateBrandName(UUID brandId, String name) {
        Optional<Brand> brandOptional = this.brandRepository.findById(brandId);

        if (brandOptional.isPresent()) {
            Brand existingBrand = brandOptional.get();
            existingBrand.setName(name);

            if (!this.validationUtil.isValid(existingBrand)) {
                this.validationUtil
                        .violations(existingBrand)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);

                throw new IllegalArgumentException("Illegal arguments!");
            }

            Brand updatedBrand = this.brandRepository.save(existingBrand);
            modelMapper.map(updatedBrand, BrandDto.class);
        }
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
        return this.brandRepository.findAll().stream().map(brand -> modelMapper.map(brand, BrandViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public BrandViewModel getBrandById(UUID brandId) {
        return modelMapper.map(this.brandRepository.findById(brandId), BrandViewModel.class);
    }

    @Override
    public void deleteBrand(UUID clientId) {
        this.brandRepository.deleteById(clientId);
    }

    @Autowired
    public void setBrandRepository(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }




}
