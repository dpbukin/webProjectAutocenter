package com.example.projectwebautocenterbukin.repositories;

import com.example.projectwebautocenterbukin.models.Model;
import com.example.projectwebautocenterbukin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
    Optional<User> findById(String id);

}
