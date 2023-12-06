package com.example.projectwebautocenterbukin.services.dto_views;

import com.example.projectwebautocenterbukin.models.enums.Role;

public class ShowUserRoleVM {
    private Role role; //Роль юзера

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
