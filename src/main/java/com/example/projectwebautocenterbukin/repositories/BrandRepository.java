package com.example.projectwebautocenterbukin.repositories;


import com.example.projectwebautocenterbukin.dtos.BrandDto;
import com.example.projectwebautocenterbukin.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BrandRepository extends JpaRepository<Brand,UUID> {
}
