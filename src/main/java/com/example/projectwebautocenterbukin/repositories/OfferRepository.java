package com.example.projectwebautocenterbukin.repositories;

import com.example.projectwebautocenterbukin.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID> {

//    @Query("SELECT o FROM Offer o WHERE o.seller.isActive = true")
//    List<OfferDto> findOffersWithActiveClients();
}
