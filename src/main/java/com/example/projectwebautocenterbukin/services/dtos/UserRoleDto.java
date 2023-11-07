package com.example.projectwebautocenterbukin.services.dtos;

import com.example.projectwebautocenterbukin.models.BaseEntity;
import com.example.projectwebautocenterbukin.models.enums.Role;

public class UserRoleDto extends BaseEntity {
    private Role role;

    public UserRoleDto(Role role) {
        this.role = role;
    }

    public UserRoleDto() {
    }

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
