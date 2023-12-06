package com.example.projectwebautocenterbukin.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;
//    now(ZoneId zone) получние метки времени в данный момент

@MappedSuperclass
public abstract class BaseEntityCreatedModified extends BaseEntity{

    private LocalDateTime created; //Дата и время создания
    private LocalDateTime modified; //Дата и время изменения

    public BaseEntityCreatedModified() {
    }
    @Column(name = "created")
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    @Column(name = "modified")
    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}

