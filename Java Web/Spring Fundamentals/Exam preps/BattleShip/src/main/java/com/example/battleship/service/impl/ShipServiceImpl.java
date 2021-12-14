package com.example.battleship.service.impl;

import com.example.battleship.model.entity.Category;
import com.example.battleship.model.entity.Ship;
import com.example.battleship.model.entity.User;
import com.example.battleship.model.service.ShipServiceModel;
import com.example.battleship.model.service.UserServiceModel;
import com.example.battleship.model.view.ShipViewModel;
import com.example.battleship.repository.ShipRepository;
import com.example.battleship.service.CategoryService;
import com.example.battleship.service.ShipService;
import com.example.battleship.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addShip(ShipServiceModel shipServiceModel) {
        User user = modelMapper.map(userService.getPrincipal(), User.class);
        Category category = modelMapper.map(categoryService.findByCategoryNameEnum(shipServiceModel.getCategory()), Category.class);
        Ship ship =
                modelMapper
                .map(shipServiceModel, Ship.class)
                .setUser(user)
                .setCategory(category);
        shipRepository.save(ship);
    }

    @Override
    public List<ShipViewModel> getAllShips() {
        return shipRepository
                .findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllAttackerShipNames() {
        User principal = modelMapper.map(userService.getPrincipal(), User.class);
        return shipRepository.findAllShipNamesByUser(principal);
    }

    @Override
    public List<String> getAllDefenderShipNames() {
        User principal = modelMapper.map(userService.getPrincipal(), User.class);
        return shipRepository.findAllShipNamesNotByUser(principal);
    }

    @Override
    public void fire(String attackerShipName, String defenderShipName) {
        Ship attacker = shipRepository.findByName(attackerShipName).orElse(null);
        Ship defender = shipRepository.findByName(defenderShipName).orElse(null);

        if (attacker != null && defender != null) {
            defender.setHealth(defender.getHealth() - attacker.getPower());
            if (defender.getHealth() > 0) {
                shipRepository.saveAndFlush(defender);
            } else {
                shipRepository.delete(defender);
            }
        }
    }
}
