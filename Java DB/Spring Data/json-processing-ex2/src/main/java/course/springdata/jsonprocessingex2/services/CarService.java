package course.springdata.jsonprocessingex2.services;

import course.springdata.jsonprocessingex2.models.dtos.CarSeedDto;
import course.springdata.jsonprocessingex2.models.dtos.export.CarAndPartsDto;
import course.springdata.jsonprocessingex2.models.dtos.export.CarExportDto;
import course.springdata.jsonprocessingex2.models.entities.Car;

import java.math.BigDecimal;
import java.util.List;

public interface CarService {
    void seedCars(CarSeedDto[] dtos);
    List<Car> getAllCars();
    Car getRandomCar();
    List<CarExportDto> getAllCarsMadeByToyotaOrderedByModelAscTravelledDistanceDesc();

    List<CarAndPartsDto> getCarsWithTheirListOfParts();

    BigDecimal getCarPriceById(Long id);
}
