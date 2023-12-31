package com.example.projectwebautocenterbukin.services.dto_views;

import com.example.projectwebautocenterbukin.models.enums.Engine;
import com.example.projectwebautocenterbukin.models.enums.Transmission;
import com.example.projectwebautocenterbukin.services.dtos.ModelDto;

import java.math.BigDecimal;

public class ShowOfferVM {
    private String id;
    private String description; // Описание
    private Engine engine; // Двигатель
    private String image_url; // URL изображения
    private int mileage; // Пробег
    private BigDecimal price; // Цена
    private Transmission transmission; // Тип трансмиссии
    private int years; // Годы выпуска
    private ShowModelVM model;
    private ShowUserVM seller;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public ShowModelVM getModel() {
        return model;
    }

    public void setModel(ShowModelVM model) {
        this.model = model;
    }

    public ShowUserVM getSeller() {
        return seller;
    }

    public void setSeller(ShowUserVM seller) {
        this.seller = seller;
    }
}
