package com.example.projectwebautocenterbukin.views;

import com.example.projectwebautocenterbukin.models.Model;
import com.example.projectwebautocenterbukin.models.User;
import com.example.projectwebautocenterbukin.models.enums.Engine;
import com.example.projectwebautocenterbukin.models.enums.Transmission;

import java.math.BigDecimal;

public class OfferViewModel {

    private String description; // Описание
    private Engine engine; // Двигатель
    private String image_url; // URL изображения
    private int mileage; // Пробег
    private BigDecimal price; // Цена
    private Transmission transmission; // Тип трансмиссии
    private int years; // Годы выпуска


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

    @Override
    public String toString() {
        return "OfferViewModel{" +
                "description='" + description + '\'' +
                ", engine=" + engine +
                ", image_url='" + image_url + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmission +
                ", years=" + years +
                '}';
    }
}
