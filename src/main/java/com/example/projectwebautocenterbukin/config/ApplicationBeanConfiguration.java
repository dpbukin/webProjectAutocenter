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
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        return modelMapper;
    }
}
