package com.example.projectwebautocenterbukin.services;

import com.example.projectwebautocenterbukin.services.dto_views.ShowModelVM;
import com.example.projectwebautocenterbukin.services.dto_views.ShowOfferVM;
import com.example.projectwebautocenterbukin.services.dtos.BrandDto;
import com.example.projectwebautocenterbukin.services.dtos.ModelDto;
import com.example.projectwebautocenterbukin.services.dtos.OfferDto;

import java.util.List;

public interface OfferService<ID> {
    List<ShowOfferVM> getAllOffers();
    void addNewOffer(OfferDto OfferDto);
    ShowOfferVM offerDetails(String offerID);
    List<ModelDto> showModel();
    List<OfferDto> showUser();
    List<ShowOfferVM> findOffersByBrandName(String brandName);
    List<ShowOfferVM> findOffersWithActiveClients();
}
