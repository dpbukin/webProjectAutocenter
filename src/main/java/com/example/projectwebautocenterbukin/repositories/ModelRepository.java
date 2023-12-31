package com.example.projectwebautocenterbukin.repositories;

import com.example.projectwebautocenterbukin.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {
    Optional<Model> findByName(String name);
}
