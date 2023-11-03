package com.example.projectwebautocenterbukin.services.dtos;

import com.example.projectwebautocenterbukin.models.BaseEntity;
import com.example.projectwebautocenterbukin.models.enums.Role;

public class UserRoleDto extends BaseEntity {
    private String name;
    private Role role;

    public UserRoleDto(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public UserRoleDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
