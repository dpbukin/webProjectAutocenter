package com.example.projectwebautocenterbukin.services.dtos;

import com.example.projectwebautocenterbukin.models.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class UserDto{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String imageUrl;
    private Role role;

    public UserDto() {
    }

    @NotEmpty(message = "The username cannot be empty")
    @Length(min = 2, message = "Username must be more than two characters and not use special characters!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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
    @NotEmpty(message = "The imageUrl cannot be empty")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @NotNull(message = "Role must be selected")
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}
