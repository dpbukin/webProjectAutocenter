package com.example.projectwebautocenterbukin.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {
    private UUID id;

    //https://1kevinson.com/why-using-uuid-instead-of-ids-in-your-java-project/

    public BaseEntity() {
    }

    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


}
