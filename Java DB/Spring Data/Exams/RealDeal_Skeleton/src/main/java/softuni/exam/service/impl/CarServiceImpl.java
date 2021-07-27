package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.CarSeedDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.constants.GlobalConstants.CARS_FILE_PATH;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files
                .readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder sb = new StringBuilder();
        CarSeedDto[] dtos = this.gson
                .fromJson(new FileReader(CARS_FILE_PATH), CarSeedDto[].class);

        Arrays.stream(dtos)
                .filter(dto -> {
                    boolean isValid = validationUtil.isValid(dto);
                    sb
                            .append(isValid ? String.format("Successfully imported car - %s - %s",
                                    dto.getMake(), dto.getModel())
                                    : "Invalid car")
                            .append(System.lineSeparator());
                    return isValid;
                })
        .map(dto -> modelMapper.map(dto, Car.class))
        .forEach(carRepository::save);

        return sb.toString().trim();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        StringBuilder sb = new StringBuilder();
        carRepository.findAllOrderByPicturesCountDescAndMake()
                .forEach(car -> sb.append(String.format("Car make - %s, model - %s%n" +
                        "\tKilometers - %d%n" +
                        "\tRegistered on - %s%n" +
                        "\tNumber of pictures - %d%n",
                        car.getMake(), car.getModel(),
                        car.getKilometers(), car.getRegisteredOn(), car.getPictures().size())));

        return sb.toString().trim();
    }

    @Override
    public Car getCarById(Long id) {
        return this.carRepository.findById(id).orElse(null);
    }
}
