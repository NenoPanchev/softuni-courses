package com.example.battleships.service;

import com.example.battleships.model.service.ShipServiceModel;
import com.example.battleships.model.view.ShipNameViewModel;
import com.example.battleships.model.view.ShipViewModel;

import java.util.List;

public interface ShipService {
    void addShip(ShipServiceModel shipServiceModel);

    List<ShipViewModel> getAllShips();

    List<ShipViewModel> getAttackerShipNames();

    List<ShipViewModel> getDefenderShipNames();

    void battle(String attackerShipName, String defenderShipName);

    void fire(String attackerName, String defenderName);
}
