package com.example.projectwebautocenterbukin.services.dtos;

import com.example.projectwebautocenterbukin.models.BaseEntityCreatedModified;
import com.example.projectwebautocenterbukin.utils.UniqueBrandName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.sql.Date;
import java.time.LocalDateTime;

public class BrandDto{
//    @UniqueBrandName
    private String name;

    public BrandDto() {
    }
    @NotBlank(message = "The name cannot be empty")
    @Size(min = 2, message = "name must be more than two characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
