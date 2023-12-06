package com.example.projectwebautocenterbukin.repositories;

import com.example.projectwebautocenterbukin.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, String> {
    @Query("SELECT o FROM Offer o WHERE o.seller.isActive = true")
    List<Offer> findOffersWithActiveClients();

    @Query("SELECT o " +
            "FROM Offer o " +
            "JOIN o.model m " +
            "JOIN m.brand b " +
            "WHERE b.name = :brandName")
    List<Offer> findOffersByBrandName(String brandName);
}
