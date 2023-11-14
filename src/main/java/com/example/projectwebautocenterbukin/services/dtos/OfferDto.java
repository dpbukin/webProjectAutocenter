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

public class OfferDto extends BaseEntityCreatedModified {
    private String description; // Описание транспортного средства
    private Engine engine; // Двигатель
    private String image_url; // URL изображения
    private int mileage; // Пробег
    private BigDecimal price; // Цена
    private Transmission transmission; // Тип трансмиссии
    private int years; // Годы выпуска
    private LocalDateTime created; // Время создания
    private LocalDateTime modified; // Время последней модификации
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
    @NotNull
    @NotEmpty(message = "The description cannot be empty")
    @Length(min = 10, message = "Brand name must be more than ten characters and not use special characters!!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @NotNull
//    @NotEmpty(message = "The engine cannot be empty")
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
    @NotNull
//    @NotEmpty(message = "The mileage cannot be empty")
    @Min(value = 1, message = "The mileage cannot be less than 1")
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    @NotNull
//    @NotEmpty(message = "The price cannot be empty")
    @DecimalMin(value = "1", message = "The cost cannot be less than 1")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @NotNull
//    @NotEmpty(message = "The transmission cannot be empty")
    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
    @NotNull
//    @NotEmpty(message = "The field cannot be empty")
    @Min(value = 1900, message = "The release date cannot be earlier than 1900")
    @Max(value = 2024, message = "The release date cannot be in the future")
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
