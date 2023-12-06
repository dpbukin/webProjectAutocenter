package com.example.projectwebautocenterbukin.models;

import com.example.projectwebautocenterbukin.models.enums.Role;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;
@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {
    private Role role;
    private Set<User> user;

    public UserRole() {
    }

    @Column(name = "role", nullable = false)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role")
    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}
