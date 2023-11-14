package com.example.projectwebautocenterbukin.services;

import com.example.projectwebautocenterbukin.services.dtos.OfferDto;
import com.example.projectwebautocenterbukin.views.OfferViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface OfferService<ID> {
    List<OfferViewModel> getAllOffers();
    OfferViewModel getOfferById(ID offerId);
    void addNewOffer(OfferDto offerDto);
    void updateOfferPrice(ID offerId, BigDecimal price);
    void deleteOffer(ID offerId);
    List<OfferDto> findOffersWithActiveClients();
}
