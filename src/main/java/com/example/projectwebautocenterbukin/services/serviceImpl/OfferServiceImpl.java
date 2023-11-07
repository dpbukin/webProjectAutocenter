package com.example.projectwebautocenterbukin.services.serviceImpl;

import com.example.projectwebautocenterbukin.services.dtos.OfferDto;
import com.example.projectwebautocenterbukin.models.Offer;
import com.example.projectwebautocenterbukin.repositories.OfferRepository;
import com.example.projectwebautocenterbukin.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService<UUID> {
    private OfferRepository offerRepository;
    private ModelMapper modelMapper;
    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferDto> getAllOffers() {
        return offerRepository.findAll().stream().map(offer -> modelMapper.map(offer, OfferDto.class)).collect(Collectors.toList());
    }

    @Override
    public OfferDto getOfferById(UUID offerId) {
        return modelMapper.map(offerRepository.findById(offerId), OfferDto.class);
    }

    @Override
    public OfferDto addNewOffer(OfferDto offerDto) {
        offerDto.setId(UUID.randomUUID());
        return modelMapper.map(offerRepository.save(modelMapper.map(offerDto, Offer.class)), OfferDto.class);
    }

    @Override
    public OfferDto updateOfferPrice(UUID offerId, BigDecimal price) {
        Optional<Offer> offerOptional = offerRepository.findById(offerId);
        if (offerOptional.isPresent()) {
            Offer existingOffer = offerOptional.get();

            existingOffer.setPrice(price);

            Offer updatedOffer = offerRepository.save(existingOffer);

            return modelMapper.map(updatedOffer, OfferDto.class);
        }
        return null;
    }


    @Override
    public void deleteOffer(UUID offerId) {
        offerRepository.deleteById(offerId);
    }

    @Override
    public List<OfferDto> findOffersWithActiveClients() {
        return offerRepository.findOffersWithActiveClients().stream().map(offer -> modelMapper.map(offer, OfferDto.class)).collect(Collectors.toList());
    }
}
