package com.example.projectwebautocenterbukin.dtos;

import com.example.projectwebautocenterbukin.models.BaseEntity;

import java.sql.Date;

public class BrandDto extends BaseEntity {
    private String name;
    private java.sql.Date created;
    private java.sql.Date modified;

    public BrandDto(String name, Date created, Date modified) {
        this.name = name;
        this.created = created;
        this.modified = modified;
    }


    public BrandDto() {
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

    @Override
    public String toString() {
        return "BrandDto{" +
                "name='" + name + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
