package com.example.projectwebautocenterbukin.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
//@Inheritance(strategy=InheritanceType.JOINED)
public class User extends BaseEntityCreatedModified {
    private String username; //Имя пользователя
    private String password; //Пароль
    private String firstName; //Имя
    private String lastName; //Фамилия
    private boolean isActive; //Сатус
    private String imageUrl; //URL изображения
    private Set<Offer> offers; //Связь с объявлением
    private UserRole role; //Роль пользователя (User or Admin)

    public User(String username, String password, String firstName, String lastName, boolean isActive, String imageUrl) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
    }

    public User() {
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String last_name) {
        this.lastName = last_name;
    }
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name = "is_active", nullable = false)
    public boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(boolean active) {
        isActive = active;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable=false)
    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "seller")
    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
