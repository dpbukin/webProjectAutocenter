package com.example.projectwebautocenterbukin.services.dtos;

import com.example.projectwebautocenterbukin.models.BaseEntity;
import com.example.projectwebautocenterbukin.models.BaseEntityCreatedModified;
import com.example.projectwebautocenterbukin.models.Offer;
import com.example.projectwebautocenterbukin.models.UserRole;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

public class UserDto extends BaseEntityCreatedModified {
    private String username; // Имя пользователя
    private String password; // Пароль
    private String firstName; // Имя
    private String lastName; // Фамилия
    private boolean isActive; // Статус активности
    private String imageUrl; // URL изображения
    private LocalDateTime created; // Время создания
    private LocalDateTime modified; // Время последней модификации
    private UserRoleDto roleDto;

    public UserDto(String username, String password, String firstName, String lastName, boolean isActive, String imageUrl, LocalDateTime created, LocalDateTime modified, UserRoleDto roleDto) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
        this.created = created;
        this.modified = modified;
        this.roleDto = roleDto;
    }

    public UserDto() {
    }
    @NotNull
    @NotEmpty(message = "The username cannot be empty")
    @Length(min = 2, message = "Username must be more than two characters and not use special characters!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @NotNull
    @NotEmpty(message = "The password cannot be empty")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @NotNull
    @NotEmpty(message = "The firstName cannot be empty")
    @Length(min = 2, message = "The firstName must be more than two characters and not use special characters!")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @NotNull
    @NotEmpty(message = "The lastName cannot be empty")
    @Length(min = 2, message = "The lastName must be more than two characters and not use special characters!")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public LocalDateTime getModified() {
        return modified;
    }

    @Override
    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public UserRoleDto getRoleDto() {
        return roleDto;
    }

    public void setRoleDto(UserRoleDto roleDto) {
        this.roleDto = roleDto;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", imageUrl='" + imageUrl + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", userRoleDto=" + roleDto +
                '}';
    }
}
