package com.example.projectwebautocenterbukin.services.serviceImpl;

import com.example.projectwebautocenterbukin.models.Offer;
import com.example.projectwebautocenterbukin.repositories.ModelRepository;
import com.example.projectwebautocenterbukin.repositories.OfferRepository;
import com.example.projectwebautocenterbukin.repositories.UserRepository;
import com.example.projectwebautocenterbukin.services.OfferService;
import com.example.projectwebautocenterbukin.services.dtos.ModelDto;
import com.example.projectwebautocenterbukin.services.dtos.OfferDto;
import com.example.projectwebautocenterbukin.services.dtos.UserDto;
import com.example.projectwebautocenterbukin.utils.ValidationUtil;
import com.example.projectwebautocenterbukin.services.dto_views.ShowOfferVM;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private OfferRepository offerRepository;
    private ModelRepository modelRepository;
    private UserRepository userRepository;
    private final ValidationUtil validationUtil;
    private ModelMapper modelMapper;
    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ModelRepository modelRepository, UserRepository userRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ShowOfferVM> getAllOffers() {
        return offerRepository.findAll().stream().map(offer -> modelMapper.map(offer, ShowOfferVM.class)).collect(Collectors.toList());
    }

    @Override
    public void addNewOffer(OfferDto offerDto) {
        Offer offer = modelMapper.map(offerDto, Offer.class);
        offer.setModel(modelRepository.findByName(offerDto.getModel()).orElseThrow());
        offer.setSeller(userRepository.findByUsername(offerDto.getSeller()).orElseThrow());

        offer.setCreated(LocalDateTime.now());
        offer.setModified(LocalDateTime.now());
        this.offerRepository.saveAndFlush(offer);
    }

    @Override
    public List<ModelDto> showModel() {
        return modelRepository.findAll().stream().map(model -> modelMapper.map(model, ModelDto.class)).collect(Collectors.toList());
    }
    @Override
    public List<UserDto> showUser() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ShowOfferVM> findOffersByBrandName(String brandName) {
        return offerRepository.findOffersByBrandName(brandName).stream().map(offer -> modelMapper.map(offer, ShowOfferVM.class)).collect(Collectors.toList());
    }
    @Override
    public ShowOfferVM offerDetails(String offerID) {
        return modelMapper.map(offerRepository.findById(offerID), ShowOfferVM.class);
    }

    @Override
    public List<ShowOfferVM> findOffersWithActiveClients() {
        return offerRepository.findOffersWithActiveClients().stream().map(offer -> modelMapper.map(offer, ShowOfferVM.class)).collect(Collectors.toList());
    }

    @Override
    public List<ShowOfferVM> findOffersBySellerUsername(String username) {
        return offerRepository.findOffersBySellerUsername(username).stream().map(offer -> modelMapper.map(offer, ShowOfferVM.class)).collect(Collectors.toList());
    }

    @Override
    public List<ShowOfferVM> findAllByOrderByPriceAsc() {
        return offerRepository.findAllByOrderByPriceAsc().stream().map(offer -> modelMapper.map(offer, ShowOfferVM.class)).collect(Collectors.toList());
    }

    @Override
    public List<ShowOfferVM> findAllByOrderByPriceDesc() {
        return offerRepository.findAllByOrderByPriceDesc().stream().map(offer -> modelMapper.map(offer, ShowOfferVM.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteOfferById(String id) {
        offerRepository.deleteById(id);
    }

    @Override
    public OfferDto getOfferById(String id) {
        return modelMapper.map(offerRepository.findById(id), OfferDto.class);
    }


//    @Override
//    public void updateOfferPrice(UUID offerId, BigDecimal price) {
//        Optional<Offer> offerOptional = offerRepository.findById(offerId);
//        if (offerOptional.isPresent()) {
//            Offer existingOffer = offerOptional.get();
//
//            existingOffer.setPrice(price);
//
//            if (!validationUtil.isValid(existingOffer)) {
//                validationUtil
//                        .violations(existingOffer)
//                        .stream()
//                        .map(ConstraintViolation::getMessage)
//                        .forEach(System.out::println);
//
//                throw new IllegalArgumentException("Illegal arguments!");
//            }
//
//            Offer updatedOffer = offerRepository.save(existingOffer);
//            modelMapper.map(updatedOffer, OfferDto.class);
//        }
//    }


//    @Override
//    public void deleteOffer(UUID offerId) {
//        offerRepository.deleteById(offerId);
//    }
//
//    @Override
//    public List<OfferDto> findOffersWithActiveClients() {
//        return offerRepository.findOffersWithActiveClients().stream().map(offer -> modelMapper.map(offer, OfferDto.class)).collect(Collectors.toList());
//    }
//    @Autowired
//    public void setOfferRepository(OfferRepository offerRepository) {
//        this.offerRepository = offerRepository;
//    }
}
