package com.example.projectwebautocenterbukin.models;

import com.example.projectwebautocenterbukin.models.enums.Category;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "models")
public class Model extends BaseEntityCreatedModified {
    private String name;
    private Category category;
    private String imageUrl;
    private int startYear;
    private int endYear;
    private Set<Offer> offers;
    private Brand brand;
    public Model() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "category")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @Column(name = "start_year")
    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }
    @Column(name = "end_year")
    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "model")
    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable=false)
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}