package course.springdata.xmlprocessingex2.services;

import course.springdata.xmlprocessingex2.models.dtos.CarSeedDto;
import course.springdata.xmlprocessingex2.models.dtos.export.CarAndPartsDto;
import course.springdata.xmlprocessingex2.models.dtos.export.CarViewRootDto;
import course.springdata.xmlprocessingex2.models.entities.Car;

import java.math.BigDecimal;
import java.util.List;

public interface CarService {
    void seedCars(List<CarSeedDto> dtos);
    List<Car> getAllCars();
    Car getRandomCar();
    CarViewRootDto getAllCarsMadeByToyotaOrderedByModelAscTravelledDistanceDesc();

    CarAndPartsDto getCarsWithTheirListOfParts();

    BigDecimal getCarPriceById(Long id);
}
