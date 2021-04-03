package spring.fundamentals.springbootlab.services.impl;

import org.springframework.stereotype.Service;
import spring.fundamentals.springbootlab.repositories.OfferRepository;
import spring.fundamentals.springbootlab.services.OfferService;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }
}
