package com.example.projectwebautocenterbukin.controllers;

import com.example.projectwebautocenterbukin.services.OfferService;
import com.example.projectwebautocenterbukin.services.dtos.OfferDto;
import com.example.projectwebautocenterbukin.views.OfferViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/offer")
public class OfferController {
    private OfferService offerService;

    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }
    @GetMapping("/all")
    List<OfferViewModel> getAllOffers(){
        return offerService.getAllOffers();
    }
    @GetMapping("/{id}")
    OfferViewModel getOfferById(@PathVariable UUID id){
        return offerService.getOfferById(id);
    }
    @PostMapping("/add")
    void addNewOffer(@RequestBody OfferDto offerDto){
        offerService.addNewOffer(offerDto);
    }
    @DeleteMapping("/delete/{id}")
    String deleteOffer(@PathVariable UUID id){
        offerService.deleteOffer(id);
        return "Offer with id = " + id + " was deleted";
    }

    @GetMapping("/findofferswithactiveclients")
    List<OfferDto> findOffersWithActiveClients(){
        return offerService.findOffersWithActiveClients();
    }


    @PutMapping("/{id}/{price}")
    void updateOfferPrice(@PathVariable UUID id, @PathVariable BigDecimal price){
        offerService.updateOfferPrice(id, price);
    }

}
