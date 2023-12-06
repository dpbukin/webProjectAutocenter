package com.example.projectwebautocenterbukin.config;


import com.example.projectwebautocenterbukin.models.Model;
import com.example.projectwebautocenterbukin.models.Offer;
import com.example.projectwebautocenterbukin.models.User;
import com.example.projectwebautocenterbukin.services.dtos.ModelDto;
import com.example.projectwebautocenterbukin.services.dtos.OfferDto;
import com.example.projectwebautocenterbukin.services.dtos.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.validation.Validation;
import jakarta.validation.Validator;

@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public Validator validator(){
        return Validation
                .buildDefaultValidatorFactory()
                .getValidator();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();



        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);


//        TypeMap<Model, ModelDto> typeMapModel = modelMapper.createTypeMap(Model.class, ModelDto.class);
//        typeMapModel.addMappings((m -> m.map(src -> src.getBrand(), ModelDto::setBrandDto)));
//
//        TypeMap<User, UserDto> typeMapUser = modelMapper.createTypeMap(User.class, UserDto.class);
//        typeMapUser.addMappings((m -> m.map(src -> src.getModified(), UserDto::setModified)));
//        typeMapUser.addMappings((m -> m.map(src -> src.getRole(), UserDto::setRoleDto)));
//
//        TypeMap<Offer, OfferDto> typeMapOffer = modelMapper.createTypeMap(Offer.class, OfferDto.class);
//        typeMapOffer.addMappings((m -> m.map(src -> src.getModel(), OfferDto::setModelDto)));
//        typeMapOffer.addMappings((m -> m.map(src -> src.getSeller(), OfferDto::setSellerDto)));



        return modelMapper;
    }
}
