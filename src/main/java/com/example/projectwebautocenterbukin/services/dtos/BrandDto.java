package com.example.projectwebautocenterbukin.services.dtos;

import com.example.projectwebautocenterbukin.models.BaseEntityCreatedModified;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.sql.Date;
import java.time.LocalDateTime;

public class BrandDto extends BaseEntityCreatedModified {
    private String name; // Имя бренда
    private LocalDateTime created; // Время создания
    private LocalDateTime modified; // Время последней модификации;

    public BrandDto(String name, LocalDateTime created, LocalDateTime modified) {
        this.name = name;
        this.created = created;
        this.modified = modified;
    }


    public BrandDto() {
    }
    @NotNull
    @NotEmpty(message = "The name cannot be empty")
    @Length(min = 2, message = "Brand name must be more than two characters and not use special characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
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
