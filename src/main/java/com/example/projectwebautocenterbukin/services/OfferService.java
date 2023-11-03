package com.example.projectwebautocenterbukin.services;

import com.example.projectwebautocenterbukin.services.dtos.OfferDto;

import java.util.List;

public interface OfferService<ID> {
    List<OfferDto> getAllOffers();
    OfferDto getOfferById(ID offerId);
    OfferDto addNewOffer(OfferDto offerDto);
    OfferDto updateOffer(ID offerId, OfferDto offerDto);
    void deleteOffer(ID offerId);
//    List<OfferDto> findOffersWithActiveClients();
}
