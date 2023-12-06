package com.example.projectwebautocenterbukin.services.dto_views;

import com.example.projectwebautocenterbukin.models.enums.Category;

public class ShowModelVM {
    private String name; //Имя модели
    private Category category; //Категория Enum
    private String imageUrl; //URl строка
    private int startYear;
    private int endYear;
    private ShowBrandVM brand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public ShowBrandVM getBrand() {
        return brand;
    }

    public void setBrand(ShowBrandVM brand) {
        this.brand = brand;
    }
}

