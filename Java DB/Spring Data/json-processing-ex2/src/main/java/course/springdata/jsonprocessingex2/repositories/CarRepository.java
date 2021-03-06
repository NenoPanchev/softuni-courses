package course.springdata.jsonprocessingex2.repositories;

import course.springdata.jsonprocessingex2.models.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make);

    @Query("SELECT (SUM(p.price)) FROM Car c " +
            "JOIN c.parts p " +
            "WHERE c.id = :id")
    BigDecimal getCarPriceById(@Param("id") Long id);
}
