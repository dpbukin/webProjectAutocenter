package com.example.projectwebautocenterbukin.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "brands")
//@Inheritance(strategy=InheritanceType.JOINED)
public class Brand extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "created")
    private java.sql.Date created;
    @Column(name = "modified")
    private java.sql.Date modified;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
    private Set<Model> model;

    public Brand(String name, Date created, Date modified) {
        this.name = name;
        this.created = created;
        this.modified = modified;
    }


    public Brand() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Model> getModel() {
        return model;
    }

    public void setModel(Set<Model> model) {
        this.model = model;
    }
}
