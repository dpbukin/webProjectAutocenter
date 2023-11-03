package com.example.projectwebautocenterbukin.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;
@MappedSuperclass
public abstract class BaseEntityCreatedModified extends BaseEntity{

    private LocalDateTime created;
    private LocalDateTime modified;

//    now(ZoneId zone) получние метки времени в данный момент
    public BaseEntityCreatedModified(LocalDateTime created, LocalDateTime modified) {
        this.created = created;
        this.modified = modified;
    }

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

