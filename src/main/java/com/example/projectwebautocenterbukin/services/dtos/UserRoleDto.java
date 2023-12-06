package com.example.projectwebautocenterbukin.services.dtos;

import com.example.projectwebautocenterbukin.models.BaseEntity;
import com.example.projectwebautocenterbukin.models.enums.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserRoleDto{
    private Role role;

    public UserRoleDto() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
