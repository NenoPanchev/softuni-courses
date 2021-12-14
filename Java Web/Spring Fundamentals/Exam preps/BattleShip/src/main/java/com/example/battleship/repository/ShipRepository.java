package com.example.battleship.repository;

import com.example.battleship.model.entity.Ship;
import com.example.battleship.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
    @Query("SELECT s.name FROM Ship s " +
            "WHERE s.user = :user")
    List<String> findAllShipNamesByUser(@Param("user") User user);

    @Query("SELECT s.name FROM Ship s " +
            "WHERE s.user NOT IN (:user)")
    List<String> findAllShipNamesNotByUser(@Param("user") User user);
    Optional<Ship> findByName(String name);
}
