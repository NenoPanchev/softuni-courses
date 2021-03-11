package course.springdata.xmlprocessingex2.services.impl;

import course.springdata.xmlprocessingex2.models.dtos.CarSeedDto;
import course.springdata.xmlprocessingex2.models.dtos.export.*;
import course.springdata.xmlprocessingex2.models.entities.Car;
import course.springdata.xmlprocessingex2.repositories.CarRepository;
import course.springdata.xmlprocessingex2.services.CarService;
import course.springdata.xmlprocessingex2.services.PartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final PartService partService;
    private final ModelMapper modelMapper;
    private final Random random;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartService partService, ModelMapper modelMapper, Random random) {
        this.carRepository = carRepository;
        this.partService = partService;
        this.modelMapper = modelMapper;
        this.random = random;
    }

    @Transactional
    @Override
    public void seedCars(List<CarSeedDto> dtos) {
        if (carRepository.count() > 0) {
            return;
        }
        dtos
                .forEach(dto -> {
                    Car car = this.modelMapper.map(dto, Car.class);
                    car.setParts(this.partService.getSetOfTenToTwentyRandomParts());
                    this.carRepository.saveAndFlush(car);
                });
    }

    @Override
    public List<Car> getAllCars() {
        return this.carRepository.findAll();
    }

    @Override
    public Car getRandomCar() {
        long randomId = (long) this.random.nextInt((int) this.carRepository.count()) + 1;
        return this.carRepository.getOne(randomId);
    }

    @Override
    public CarViewRootDto getAllCarsMadeByToyotaOrderedByModelAscTravelledDistanceDesc() {
        List<CarExportDto> dtos = this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota")
                .stream()
                .map(entity -> this.modelMapper.map(entity, CarExportDto.class))
                .collect(Collectors.toList());

        CarViewRootDto rootDto = new CarViewRootDto();
        rootDto.setCars(dtos);
        return rootDto;
    }

    @Override
    public CarAndPartsDto getCarsWithTheirListOfParts() {
        List<CarExportWithoutIdDto> dtos = this.carRepository.findAll().stream()
                .map(car -> {
                    CarExportWithoutIdDto carDto = this.modelMapper.map(car, CarExportWithoutIdDto.class);
                    List<PartExportDto> partsDto = car.getParts().stream()
                            .map(part -> this.modelMapper.map(part, PartExportDto.class))
                            .collect(Collectors.toList());
                    PartViewRootDto partViewRootDto = new PartViewRootDto();
                    partViewRootDto.setParts(partsDto);
                    carDto.setParts(partViewRootDto);
                    return carDto;
                })
                .collect(Collectors.toList());
        CarAndPartsDto rootDto = new CarAndPartsDto();
        rootDto.setCars(dtos);
        return rootDto;
    }

    @Override
    public BigDecimal getCarPriceById(Long id) {
        return this.carRepository.getCarPriceById(id);
    }

}
