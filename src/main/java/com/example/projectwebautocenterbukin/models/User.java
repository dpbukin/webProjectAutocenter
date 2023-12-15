package com.example.projectwebautocenterbukin.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntityCreatedModified implements Serializable {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String imageUrl;
    private Set<Offer> offers;
    private UserRole role;

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
