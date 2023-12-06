package com.example.projectwebautocenterbukin.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;
//https://1kevinson.com/why-using-uuid-instead-of-ids-in-your-java-project/

@MappedSuperclass
public abstract class BaseEntity {
    private String id;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
