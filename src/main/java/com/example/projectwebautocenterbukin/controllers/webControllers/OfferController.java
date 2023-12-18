package com.example.projectwebautocenterbukin.controllers.webControllers;

import com.example.projectwebautocenterbukin.models.User;
import com.example.projectwebautocenterbukin.services.OfferService;
import com.example.projectwebautocenterbukin.services.dto_views.ShowOfferVM;
import com.example.projectwebautocenterbukin.services.dto_views.UserProfileView;
import com.example.projectwebautocenterbukin.services.dtos.OfferDto;
import com.example.projectwebautocenterbukin.services.serviceImpl.AuthService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.security.Principal;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private static final Logger LOG = LogManager.getLogger(Controller.class);
    @Autowired
    private OfferService offerService;
    @Autowired
    private AuthService authService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/all")
    public String showAllOffers(Principal principal, Model model){
        LOG.log(Level.INFO, "Show all offers for " + principal.getName());
        model.addAttribute("offerInfos", offerService.getAllOffers());
        return "offers-all";
    }

    @GetMapping("/add")
    public String addOffer(Model model) {
        model.addAttribute("availableModel", offerService.showModel());
        return "offer-add";
    }

    @ModelAttribute("offerModel")
    public OfferDto initOffer() {
        return new OfferDto();
    }
    @PostMapping("/add")
    public String addOffer(@Valid OfferDto offerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Principal principal){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerModel", offerDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel",
                    bindingResult);
            return "redirect:/offers/add";
        }
        offerDto.setSeller(principal.getName());
        offerService.addNewOffer(offerDto);

        LOG.log(Level.INFO, "Add new offer for " + principal.getName());

        return "redirect:/";
    }

    @GetMapping("/active_offers")
    public String OffersWithActiveClients(Principal principal, Model model) {
        LOG.log(Level.INFO, "Show all active offers for " + principal.getName());
        model.addAttribute("offerInfosActive", offerService.findOffersWithActiveClients());
        return "active_clients";
    }

    @GetMapping("/my_offers")
    public String showMyOffers(Principal principal, Model model){
        LOG.log(Level.INFO, "Show my all offers for " + principal.getName());
        String username = principal.getName();
        model.addAttribute("offersUserInfos", offerService.findOffersBySellerUsername(username));
        return "user_offers";
    }

    @DeleteMapping("/delete/{id}")
    void deleteOffer(@PathVariable String id){
        offerService.deleteOfferById(id);
    }

    @GetMapping("/sorted/asc")
    public String getSortedOffersAsc(Principal principal, Model model) {
        LOG.log(Level.INFO, "Looked through the sorted offers for " + principal.getName());
        model.addAttribute("offerInfosActive", offerService.findAllByOrderByPriceAsc());
        return "active_clients";
    }

    @GetMapping("/sorted/desc")
    public String getSortedOffersDesc(Principal principal, Model model) {
        LOG.log(Level.INFO, "Looked through the sorted offers for " + principal.getName());
        model.addAttribute("offerInfosActive", offerService.findAllByOrderByPriceDesc());
        return "active_clients";
    }


//    @GetMapping("/details/{id}")
//    String getOfferDetailsById(@PathVariable String id, Model model){
//        model.addAttribute("offerDetail", offerService.getOfferById(id));
//        System.out.println(offerService.getOfferById(id));
//        return "offer-details";
//    }

}
