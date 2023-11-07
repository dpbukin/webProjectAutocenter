package com.example.projectwebautocenterbukin.controllers;

import com.example.projectwebautocenterbukin.services.OfferService;
import com.example.projectwebautocenterbukin.services.dtos.OfferDto;
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
    List<OfferDto> getAllOffers(){
        return offerService.getAllOffers();
    }
    @GetMapping("/{id}")
    OfferDto getOfferById(@PathVariable UUID id){
        return offerService.getOfferById(id);
    }
    @PostMapping("/add")
    OfferDto addNewOffer(@RequestBody OfferDto offerDto){
        return offerService.addNewOffer(offerDto);
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


    @PutMapping("/{id}/{name}")
    OfferDto updateOfferPrice(@PathVariable UUID id, @PathVariable BigDecimal price){
        return offerService.updateOfferPrice(id, price);
    }

}
