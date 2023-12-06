package com.example.projectwebautocenterbukin.models;

import com.example.projectwebautocenterbukin.models.enums.Engine;
import com.example.projectwebautocenterbukin.models.enums.Transmission;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntityCreatedModified {
    private String description;
    private Engine engine;
    private String image_url;
    private int mileage;
    private BigDecimal price;
    private Transmission transmission;
    private int years;
    private Model model;
    private User seller;

    public Offer() {
    }
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Column(name = "engine")
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    @Column(name = "image_url")
    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    @Column(name = "mileage")
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "transmission")
    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
    @Column(name = "year")
    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable=false)
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    @ManyToOne(optional = false)
    @JoinColumn(name = "seller_id", referencedColumnName = "id", nullable=false)
    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
