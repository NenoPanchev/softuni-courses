package com.example.battleship.service;

import com.example.battleship.model.service.ShipServiceModel;
import com.example.battleship.model.view.ShipViewModel;

import java.util.List;

public interface ShipService {

    void addShip(ShipServiceModel shipServiceModel);

    List<ShipViewModel> getAllShips();

    List<String> getAllAttackerShipNames();

    List<String> getAllDefenderShipNames();

    void fire(String attackerShipName, String defenderShipName);
}
