package com.example.projectwebautocenterbukin.services.serviceImpl;

import com.example.projectwebautocenterbukin.services.dtos.OfferDto;
import com.example.projectwebautocenterbukin.models.Offer;
import com.example.projectwebautocenterbukin.repositories.OfferRepository;
import com.example.projectwebautocenterbukin.services.OfferService;
import com.example.projectwebautocenterbukin.utils.ValidationUtil;
import com.example.projectwebautocenterbukin.views.OfferViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.validation.ConstraintViolation;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService<UUID> {
    private OfferRepository offerRepository;

    private final ValidationUtil validationUtil;
    private ModelMapper modelMapper;
    @Autowired
    public OfferServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferViewModel> getAllOffers() {
        return offerRepository.findAll().stream().map(offer -> modelMapper.map(offer, OfferViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public OfferViewModel getOfferById(UUID offerId) {
        return modelMapper.map(offerRepository.findById(offerId), OfferViewModel.class);
    }

    @Override
    public void addNewOffer(OfferDto offerDto) {
        offerDto.setId(UUID.randomUUID());

        if (!validationUtil.isValid(offerDto)) {
            validationUtil
                    .violations(offerDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }

        Offer offer = modelMapper.map(offerDto, Offer.class);
        Offer savedOffer = offerRepository.save(offer);
        this.offerRepository.saveAndFlush(savedOffer);
    }

    @Override
    public void updateOfferPrice(UUID offerId, BigDecimal price) {
        Optional<Offer> offerOptional = offerRepository.findById(offerId);
        if (offerOptional.isPresent()) {
            Offer existingOffer = offerOptional.get();

            existingOffer.setPrice(price);

            if (!validationUtil.isValid(existingOffer)) {
                validationUtil
                        .violations(existingOffer)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);

                throw new IllegalArgumentException("Illegal arguments!");
            }

            Offer updatedOffer = offerRepository.save(existingOffer);
            modelMapper.map(updatedOffer, OfferDto.class);
        }
    }


    @Override
    public void deleteOffer(UUID offerId) {
        offerRepository.deleteById(offerId);
    }

    @Override
    public List<OfferDto> findOffersWithActiveClients() {
        return offerRepository.findOffersWithActiveClients().stream().map(offer -> modelMapper.map(offer, OfferDto.class)).collect(Collectors.toList());
    }
    @Autowired
    public void setOfferRepository(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }
}
