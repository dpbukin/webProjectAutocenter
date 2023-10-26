package com.example.projectwebautocenterbukin.dtos;

import com.example.projectwebautocenterbukin.models.BaseEntity;
import com.example.projectwebautocenterbukin.models.enums.Engine;
import com.example.projectwebautocenterbukin.models.enums.Transmission;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class OfferDto extends BaseEntity {
    private String description;
    private Engine engine;
    private String image_url;
    private int mileage;
    private double price;
    private Transmission transmission;
    private int years;
    private int count;
    private java.sql.Date created;
    private java.sql.Date modified;
    private ModelDto modelDto;
    private UserDto seller;


    public OfferDto(String description, Engine engine, String image_url, int mileage, double price, Transmission transmission, int years, int count, Date created, Date modified, ModelDto modelDto, UserDto seller) {
        this.description = description;
        this.engine = engine;
        this.image_url = image_url;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.years = years;
        this.count = count;
        this.created = created;
        this.modified = modified;
        this.modelDto = modelDto;
        this.seller = seller;
    }

    public OfferDto() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public ModelDto getModelDto() {
        return modelDto;
    }

    public void setModelDto(ModelDto modelDto) {
        this.modelDto = modelDto;
    }

    public UserDto getSeller() {
        return seller;
    }

    public void setSeller(UserDto seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "OfferDto{" +
                "description='" + description + '\'' +
                ", engine=" + engine +
                ", image_url='" + image_url + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmission +
                ", years=" + years +
                ", count=" + count +
                ", created=" + created +
                ", modified=" + modified +
                ", modelDto=" + modelDto +
                ", seller=" + seller +
                '}';
    }
}
