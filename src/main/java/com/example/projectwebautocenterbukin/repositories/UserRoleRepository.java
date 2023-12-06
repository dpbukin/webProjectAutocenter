package com.example.projectwebautocenterbukin.repositories;

import com.example.projectwebautocenterbukin.models.Model;
import com.example.projectwebautocenterbukin.models.UserRole;
import com.example.projectwebautocenterbukin.models.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
    Optional<UserRole> findByRole(Role role);

}
