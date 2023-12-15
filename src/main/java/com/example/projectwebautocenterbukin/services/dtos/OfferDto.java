package com.example.projectwebautocenterbukin.services.dtos;

import com.example.projectwebautocenterbukin.models.BaseEntity;
import com.example.projectwebautocenterbukin.models.BaseEntityCreatedModified;
import com.example.projectwebautocenterbukin.models.Model;
import com.example.projectwebautocenterbukin.models.User;
import com.example.projectwebautocenterbukin.models.enums.Engine;
import com.example.projectwebautocenterbukin.models.enums.Transmission;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

public class OfferDto{
    private String id;
    private String description;
    private Engine engine;
    private String image_url;
    private int mileage;
    private BigDecimal price;
    private Transmission transmission;
    private int years;
    private String model;
    private String seller;

    public OfferDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Length(min = 10, message = "Description must be more than ten characters!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @NotNull(message = "Engine must be selected")
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    @NotEmpty(message = "The imageUrl cannot be empty")
    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }


    @Min(value = 1, message = "The mileage cannot be less than 1")
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @NotNull(message = "The Price cannot be empty")
    @DecimalMin(value = "1", message = "The cost cannot be less than 1")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull(message = "Transmission must be selected")
    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Min(value = 1900, message = "The release date cannot be earlier than 1900")
    @Max(value = 2024, message = "The release date cannot be in the future")
    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    @NotBlank(message = "Model must be selected")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
