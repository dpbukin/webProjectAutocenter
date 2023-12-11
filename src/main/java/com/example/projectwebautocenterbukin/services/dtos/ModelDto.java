package com.example.projectwebautocenterbukin.services.dtos;

import com.example.projectwebautocenterbukin.models.enums.Category;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public class ModelDto{
    private String name;
    private Category category;
    private String imageUrl;
    private int startYear;
    private int endYear;
    private String brand;
    public ModelDto() {
    }

    @NotEmpty(message = "Model name must not be null or empty!")
    @Size(min = 2, message = "name must be more than two characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @NotNull(message = "Category must be selected")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @NotEmpty(message = "The imageUrl cannot be empty")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Min(value = 1900, message = "The release start date cannot be earlier than 1900")
    @Max(value = 2024, message = "The release start date cannot be in the future")
    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    @Min(value = 1900, message = "The date cannot be earlier than 1900")
    @Max(value = 2024, message = "The date cannot be in the future")
    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }
    @NotBlank(message = "Brand must be selected")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
