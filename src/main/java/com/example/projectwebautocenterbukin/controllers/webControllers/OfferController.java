package com.example.projectwebautocenterbukin.controllers.webControllers;

import com.example.projectwebautocenterbukin.services.OfferService;
import com.example.projectwebautocenterbukin.services.dto_views.ShowOfferVM;
import com.example.projectwebautocenterbukin.services.dtos.OfferDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;

@Controller
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    private OfferService offerService;


    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/all")
    public String showAllOffers(Model model){
        model.addAttribute("offerInfos", offerService.getAllOffers());
        return "offers-all";
    }

    @GetMapping("/add")
    public String addOffer(Model model) {
        model.addAttribute("availableModel", offerService.showModel());
        model.addAttribute("availableUser", offerService.showUser());
        return "offer-add";
    }

    @ModelAttribute("offerModel")
    public OfferDto initOffer() {
        return new OfferDto();
    }
    @PostMapping("/add")
    public String addOffer(@Valid OfferDto offerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerModel", offerDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel",
                    bindingResult);
            return "redirect:/offers/add";
        }
        offerService.addNewOffer(offerDto);

        return "redirect:/";
    }

    @GetMapping("/active_offers")
    public String OffersWithActiveClients(Model model) {
        model.addAttribute("offerInfosActive", offerService.findOffersWithActiveClients());
        return "active_clients";
    }


}
