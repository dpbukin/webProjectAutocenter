package com.example.projectwebautocenterbukin.services.dtos;

import com.example.projectwebautocenterbukin.utils.UniqueBrandName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BrandDto{
    @UniqueBrandName
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
