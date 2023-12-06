package com.example.projectwebautocenterbukin.services.serviceImpl;

import com.example.projectwebautocenterbukin.services.dtos.BrandDto;
import com.example.projectwebautocenterbukin.models.Brand;
import com.example.projectwebautocenterbukin.services.BrandService;
import com.example.projectwebautocenterbukin.utils.ValidationUtil;
import com.example.projectwebautocenterbukin.services.dto_views.ShowBrandVM;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projectwebautocenterbukin.repositories.BrandRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository;
    private final ValidationUtil validationUtil;
    private ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ShowBrandVM> getAllBrands() {
        return this.brandRepository.findAll().stream().map(brand -> modelMapper.map(brand, ShowBrandVM.class)).collect(Collectors.toList());
    }

    @Override
    public void addNewBrand(BrandDto brandDto) {
        if (!this.validationUtil.isValid(brandDto)) {

            this.validationUtil
                    .violations(brandDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }

        Brand brand = this.modelMapper.map(brandDto, Brand.class);
        brand.setCreated(LocalDateTime.now());
        brand.setModified(LocalDateTime.now());

        this.brandRepository.saveAndFlush(brand);

    }
    @Override
    public ShowBrandVM brandDetails(String brandName) {
        return modelMapper.map(brandRepository.findByName(brandName).orElse(null), ShowBrandVM.class);
    }

    @Override
    public ShowBrandVM getBrandById(String id) {
        return modelMapper.map(brandRepository.findById(id), ShowBrandVM.class);
    }

//    @Override
//    public void updateBrandName(UUID brandId, String name) {
//        Optional<Brand> brandOptional = this.brandRepository.findById(brandId);
//
//        if (brandOptional.isPresent()) {
//            Brand existingBrand = brandOptional.get();
//            existingBrand.setName(name);
//
//            if (!this.validationUtil.isValid(existingBrand)) {
//                this.validationUtil
//                        .violations(existingBrand)
//                        .stream()
//                        .map(ConstraintViolation::getMessage)
//                        .forEach(System.out::println);
//
//                throw new IllegalArgumentException("Illegal arguments!");
//            }
//
//            Brand updatedBrand = this.brandRepository.save(existingBrand);
//            modelMapper.map(updatedBrand, BrandDto.class);
//        }
//    }

//    @Override
//    public void deleteBrand(UUID clientId) {
//        this.brandRepository.deleteById(clientId);
//    }
}
