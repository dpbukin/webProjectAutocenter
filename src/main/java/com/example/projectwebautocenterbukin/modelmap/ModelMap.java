package com.example.projectwebautocenterbukin.modelmap;


import com.example.projectwebautocenterbukin.models.*;
import com.example.projectwebautocenterbukin.services.dtos.*;
import org.modelmapper.*;
import org.modelmapper.config.Configuration;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class ModelMap {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

//        TypeMap<Brand, BrandDto> typeMapBrand = modelMapper.createTypeMap(Brand.class,BrandDto.class);
//        typeMapBrand.addMappings((m->m.map(src -> src.getName(),BrandDto::setName)));
//        typeMapBrand.addMappings((m->m.map(src -> src.getCreated(), BrandDto::setCreated)));
//        typeMapBrand.addMappings(m->m.map(src -> src.getModified() , BrandDto::setModified));
//
        TypeMap<Model, ModelDto> typeMapModel = modelMapper.createTypeMap(Model.class, ModelDto.class);
//        typeMapModel.addMappings((m -> m.map(src -> src.getName(), ModelDto::setName)));
//        typeMapModel.addMappings((m -> m.map(src -> src.getCategory(), ModelDto::setCategory)));
//        typeMapModel.addMappings((m -> m.map(src -> src.getImageUrl(), ModelDto::setImageUrl)));
//        typeMapModel.addMappings((m -> m.map(src -> src.getStartYear(), ModelDto::setStartYear)));
//        typeMapModel.addMappings((m -> m.map(src -> src.getEndYear(), ModelDto::setEndYear)));
//        typeMapModel.addMappings((m -> m.map(src -> src.getCreated(), ModelDto::setCreated)));
//        typeMapModel.addMappings((m -> m.map(src -> src.getModified(), ModelDto::setModified)));
        typeMapModel.addMappings((m -> m.map(src -> src.getBrand(), ModelDto::setBrandDto)));
//
        TypeMap<User, UserDto> typeMapUser = modelMapper.createTypeMap(User.class, UserDto.class);
//        typeMapUser.addMappings((m -> m.map(src -> src.getUsername(), UserDto::setUsername)));
//        typeMapUser.addMappings((m -> m.map(src -> src.getPassword(), UserDto::setPassword)));
//        typeMapUser.addMappings((m -> m.map(src -> src.getFirstName(), UserDto::setFirstName)));
//        typeMapUser.addMappings((m -> m.map(src -> src.getLastName(), UserDto::setLastName)));
//        typeMapUser.addMappings((m -> m.map(src -> src.getIsActive(), UserDto::setIsActive)));
//        typeMapUser.addMappings((m -> m.map(src -> src.getImageUrl(), UserDto::setImageUrl)));
//        typeMapUser.addMappings((m -> m.map(src -> src.getCreated(), UserDto::setCreated)));
        typeMapUser.addMappings((m -> m.map(src -> src.getModified(), UserDto::setModified)));
        typeMapUser.addMappings((m -> m.map(src -> src.getRole(), UserDto::setRoleDto)));
//
        TypeMap<Offer, OfferDto> typeMapOffer = modelMapper.createTypeMap(Offer.class, OfferDto.class);
//        typeMapOffer.addMappings((m -> m.map(src -> src.getDescription(), OfferDto::setDescription)));
//        typeMapOffer.addMappings((m -> m.map(src -> src.getEngine(), OfferDto::setEngine)));
//        typeMapOffer.addMappings((m -> m.map(src -> src.getImage_url(), OfferDto::setImage_url)));
//        typeMapOffer.addMappings((m -> m.map(src -> src.getMileage(), OfferDto::setMileage)));
//        typeMapOffer.addMappings((m -> m.map(src -> src.getPrice(), OfferDto::setPrice)));
//        typeMapOffer.addMappings((m -> m.map(src -> src.getTransmission(), OfferDto::setTransmission)));
//        typeMapOffer.addMappings((m -> m.map(src -> src.getYears(), OfferDto::setYears)));
//        typeMapOffer.addMappings((m -> m.map(src -> src.getCreated(), OfferDto::setCreated)));
//        typeMapOffer.addMappings((m -> m.map(src -> src.getModified(), OfferDto::setModified)));
        typeMapOffer.addMappings((m -> m.map(src -> src.getModel(), OfferDto::setModelDto)));
        typeMapOffer.addMappings((m -> m.map(src -> src.getSeller(), OfferDto::setSellerDto)));
//
//        TypeMap<UserRole, UserRoleDto> typeMapUserRole = modelMapper.createTypeMap(UserRole.class, UserRoleDto.class);
//        typeMapUserRole.addMappings((m -> m.map(src -> src.getRole(), UserRoleDto::setRole)));


        return modelMapper;
    }
}
