package com.example.projectwebautocenterbukin.models;

import com.example.projectwebautocenterbukin.models.enums.Role;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;
@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {
    private String name;
    private Role role;
    private Set<User> user;

    public UserRole(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public UserRole() {
    }
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "role")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}
