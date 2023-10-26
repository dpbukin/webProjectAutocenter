package com.example.projectwebautocenterbukin.models;

import com.example.projectwebautocenterbukin.models.enums.Role;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;
@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "role")
    private Role role;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<User> user;

    public UserRole(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public UserRole() {
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

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}
