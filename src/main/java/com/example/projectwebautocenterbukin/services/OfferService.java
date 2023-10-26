package com.example.projectwebautocenterbukin.services;

import com.example.projectwebautocenterbukin.dtos.OfferDto;
import com.example.projectwebautocenterbukin.models.Offer;

import java.util.List;

public interface OfferService<ID> {
    List<OfferDto> getAllOffers();
    OfferDto getOfferById(ID offerId);
    OfferDto addNewOffer(OfferDto offerDto);
    OfferDto updateOffer(ID offerId, OfferDto offerDto);
    void deleteOffer(ID offerId);
//    List<OfferDto> findOffersWithActiveClients();
}
