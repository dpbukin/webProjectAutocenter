package com.example.projectwebautocenterbukin.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntityCreatedModified {
    private String name; //Наименование бренда
    private Set<Model> model; //Связь с моделью

    public Brand(String name) {
        this.name = name;
    }

    public Brand() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "brand")
    public Set<Model> getModel() {
        return model;
    }

    public void setModel(Set<Model> model) {
        this.model = model;
    }
}
