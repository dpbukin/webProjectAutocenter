package com.example.projectwebautocenterbukin.services.serviceImpl;

import com.example.projectwebautocenterbukin.services.dtos.BrandDto;
import com.example.projectwebautocenterbukin.models.Brand;
import com.example.projectwebautocenterbukin.services.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projectwebautocenterbukin.repositories.BrandRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService<UUID> {

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public BrandDto addNewBrand(BrandDto brandDto) {
        brandDto.setId(UUID.randomUUID());
        return  modelMapper.map(brandRepository.save(modelMapper.map(brandDto, Brand.class)), BrandDto.class);
    }

    @Override
    public BrandDto updateBrand(UUID brandId, BrandDto brandDto) {
        return null;
    }

    @Override
    public List<BrandDto> getAllBrands() {
        return brandRepository.findAll().stream().map(brand -> modelMapper.map(brand, BrandDto.class)).collect(Collectors.toList());
    }

    @Override
    public BrandDto getBrandById(UUID brandId) {
        return modelMapper.map(brandRepository.findById(brandId), BrandDto.class);
    }

    @Override
    public void deleteBrand(UUID clientId) {
        brandRepository.deleteById(clientId);
    }
}
