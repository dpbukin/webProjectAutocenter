package com.example.projectwebautocenterbukin.services.dtos;

import com.example.projectwebautocenterbukin.models.BaseEntity;
import com.example.projectwebautocenterbukin.models.BaseEntityCreatedModified;
import com.example.projectwebautocenterbukin.models.Model;
import com.example.projectwebautocenterbukin.models.User;
import com.example.projectwebautocenterbukin.models.enums.Engine;
import com.example.projectwebautocenterbukin.models.enums.Transmission;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

public class OfferDto extends BaseEntityCreatedModified {
    private String description;
    private Engine engine;
    private String image_url;
    private int mileage;
    private BigDecimal price;
    private Transmission transmission;
    private int years;
    private LocalDateTime created;
    private LocalDateTime modified;
    private ModelDto modelDto;
    private UserDto sellerDto;


    public OfferDto(String description, Engine engine, String image_url, int mileage, BigDecimal price, Transmission transmission, int years, LocalDateTime created, LocalDateTime modified, ModelDto modelDto, UserDto sellerDto) {
        this.description = description;
        this.engine = engine;
        this.image_url = image_url;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.years = years;
        this.created = created;
        this.modified = modified;
        this.modelDto = modelDto;
        this.sellerDto = sellerDto;
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
    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public LocalDateTime getModified() {
        return modified;
    }

    @Override
    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public ModelDto getModelDto() {
        return modelDto;
    }

    public void setModelDto(ModelDto modelDto) {
        this.modelDto = modelDto;
    }

    public UserDto getSellerDto() {
        return sellerDto;
    }

    public void setSellerDto(UserDto sellerDto) {
        this.sellerDto = sellerDto;
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
                ", created=" + created +
                ", modified=" + modified +
                ", modelDto=" + modelDto +
                ", sellerDto=" + sellerDto +
                '}';
    }
}
