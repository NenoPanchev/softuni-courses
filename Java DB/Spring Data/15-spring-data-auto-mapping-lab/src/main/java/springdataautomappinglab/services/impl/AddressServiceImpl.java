package springdataautomappinglab.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springdataautomappinglab.entities.Address;
import springdataautomappinglab.repositories.AddressRepository;
import springdataautomappinglab.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    public AddressServiceImpl(AddressRepository addressRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(Address address) {
        this.addressRepository.saveAndFlush(address);
    }
}
