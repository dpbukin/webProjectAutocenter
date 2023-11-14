package com.example.projectwebautocenterbukin.services.dtos;

import com.example.projectwebautocenterbukin.models.BaseEntity;
import com.example.projectwebautocenterbukin.models.BaseEntityCreatedModified;
import com.example.projectwebautocenterbukin.models.enums.Category;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.sql.Date;
import java.time.LocalDateTime;

public class ModelDto extends BaseEntityCreatedModified {
    private String name; // Имя модели
    private Category category; // Категория модели
    private String imageUrl; // URL изображения
    private int startYear; // Начальный год выпуска
    private int endYear; // Конечный год выпуска
    private LocalDateTime created; // Время создания
    private LocalDateTime modified; // Время последней модификации
    private BrandDto brandDto;



    public ModelDto(String name, Category category, String imageUrl, int startYear, int endYear, LocalDateTime created, LocalDateTime modified, BrandDto brandDto) {
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
        this.brandDto = brandDto;
    }

    public ModelDto() {
    }
    @NotNull
    @NotEmpty(message = "The name cannot be empty")
    @Length(min = 2, message = "Brand name must be more than two characters and not use special characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//    @NotEmpty(message = "The category cannot be empty")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    @NotNull
    @NotEmpty(message = "The imageUrl cannot be empty")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @NotNull
//    @NotEmpty(message = "The startYear cannot be empty")
    @Min(value = 1900, message = "The release start date cannot be earlier than 1900")
    @Max(value = 2024, message = "The release start date cannot be in the future")
    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }
    @NotNull
//    @NotEmpty(message = "The field cannot be empty")
    @Min(value = 1900, message = "The graduation date cannot be earlier than 1900")
    @Max(value = 2024, message = "The release end date cannot be in the future")
    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public BrandDto getBrandDto() {
        return brandDto;
    }

    public void setBrandDto(BrandDto brandDto) {
        this.brandDto = brandDto;
    }

    @Override
    public String toString() {
        return "ModelDto{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", created=" + created +
                ", modified=" + modified +
                ", brandDto=" + brandDto +
                '}';
    }
}
