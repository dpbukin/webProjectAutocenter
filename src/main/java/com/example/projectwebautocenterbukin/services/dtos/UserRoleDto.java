package com.example.projectwebautocenterbukin.services.dtos;

import com.example.projectwebautocenterbukin.models.BaseEntity;
import com.example.projectwebautocenterbukin.models.enums.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserRoleDto extends BaseEntity {
    private Role role; //Роль юзера

    public UserRoleDto(Role role) {
        this.role = role;
    }

    public UserRoleDto() {
    }
//    @NotNull
//    @NotEmpty(message = "The role cannot be empty")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRoleDto{" +
                "role=" + role +
                '}';
    }
}
