package com.example.projectwebautocenterbukin.services.dto_views;

import com.example.projectwebautocenterbukin.models.enums.Role;

public class UserProfileView {
    private String username; //Имя пользователя
    private String firstName; //Имя
    private String lastName; //Фамилия
    private String imageUrl; //URL изображения

    public UserProfileView() {
    }

    public UserProfileView(String username, String firstName, String lastName, String imageUrl) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
