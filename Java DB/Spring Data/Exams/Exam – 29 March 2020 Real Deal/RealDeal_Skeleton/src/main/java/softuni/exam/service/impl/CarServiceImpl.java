package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.models.Car;
import softuni.exam.models.dtos.CarSeedDto;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.constants.GlobalConstants.*;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.carRepository = carRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder sb = new StringBuilder();
        CarSeedDto[] dtos = this.gson.fromJson(new FileReader(CARS_FILE_PATH), CarSeedDto[].class);

        Arrays.stream(dtos)
                .forEach(dto -> {
                    Car car = this.carRepository.getByMakeAndModelAndKilometers(dto.getMake(), dto.getModel(), dto.getKilometers());
                    if (this.validationUtil.isValid(dto) && car == null) {
                        this.carRepository.saveAndFlush(this.modelMapper.map(dto, Car.class));
                        sb.append(String.format("Successfully imported car - %s - %s",
                                dto.getMake(), dto.getModel()));
                    } else {
                        sb.append("Invalid car");
                    }
                    sb.append(System.lineSeparator());
                });

        return sb.toString();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        StringBuilder sb = new StringBuilder();
        this.carRepository.findAllOrderByPicturesCountDesc()
                .forEach(car -> sb.append(String.format("Car make - %s, model - %s%n" +
                        "\tKilometers - %d%n" +
                        "\tRegistered on - %s%n" +
                        "\tNumber of pictures - %d%n",
                        car.getMake(), car.getModel(),
                        car.getKilometers(),
                        car.getRegisteredOn(),
                        car.getPictures().size())));
        return sb.toString();
    }

    @Override
    public Car getById(Long id) {
        return this.carRepository.getById(id);
    }
}
