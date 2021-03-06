package course.springdata.jsonprocessingex2.services.impl;

import course.springdata.jsonprocessingex2.models.dtos.CarSeedDto;
import course.springdata.jsonprocessingex2.models.dtos.export.CarAndPartsDto;
import course.springdata.jsonprocessingex2.models.dtos.export.CarExportDto;
import course.springdata.jsonprocessingex2.models.dtos.export.CarExportWithoutIdDto;
import course.springdata.jsonprocessingex2.models.dtos.export.PartExportDto;
import course.springdata.jsonprocessingex2.models.entities.Car;
import course.springdata.jsonprocessingex2.repositories.CarRepository;
import course.springdata.jsonprocessingex2.services.CarService;
import course.springdata.jsonprocessingex2.services.PartService;
import org.modelmapper.ModelMapper;
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

    public CarServiceImpl(CarRepository carRepository, PartService partService, ModelMapper modelMapper, Random random) {
        this.carRepository = carRepository;
        this.partService = partService;
        this.modelMapper = modelMapper;
        this.random = random;
    }

    @Transactional
    @Override
    public void seedCars(CarSeedDto[] dtos) {
        if (carRepository.count() > 0) {
            return;
        }
        Arrays.stream(dtos)
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
    public List<CarExportDto> getAllCarsMadeByToyotaOrderedByModelAscTravelledDistanceDesc() {
        return this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota")
                .stream()
                .map(entity -> this.modelMapper.map(entity, CarExportDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<CarAndPartsDto> getCarsWithTheirListOfParts() {
        return this.carRepository.findAll().stream()
                .map(car -> {
                    CarExportWithoutIdDto carDto = this.modelMapper.map(car, CarExportWithoutIdDto.class);
                    List<PartExportDto> partsDto = car.getParts().stream()
                            .map(part -> this.modelMapper.map(part, PartExportDto.class))
                            .collect(Collectors.toList());

                    CarAndPartsDto carAndPartsDto = new CarAndPartsDto();
                    carAndPartsDto.setCar(carDto);
                    carAndPartsDto.setParts(partsDto);
                    return carAndPartsDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal getCarPriceById(Long id) {
        return this.carRepository.getCarPriceById(id);
    }

}
