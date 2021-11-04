package com.example.battleships.service.impl;

import com.example.battleships.model.entity.Category;
import com.example.battleships.model.entity.Ship;
import com.example.battleships.model.entity.User;
import com.example.battleships.model.service.ShipServiceModel;
import com.example.battleships.model.view.ShipNameViewModel;
import com.example.battleships.model.view.ShipViewModel;
import com.example.battleships.repository.ShipRepository;
import com.example.battleships.service.CategoryService;
import com.example.battleships.service.ShipService;
import com.example.battleships.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;
    private final HttpSession httpSession;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService, HttpSession httpSession) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
        this.httpSession = httpSession;
    }

    @Override
    public void addShip(ShipServiceModel shipServiceModel) {
        User user = modelMapper.map(userService.getPrincipal(), User.class);
        Category category = modelMapper.map(categoryService.findByCategoryNameEnum(shipServiceModel.getCategory()), Category.class);
        Ship ship = modelMapper.map(shipServiceModel, Ship.class)
                .setCategory(category)
                .setUser(user);

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
    public List<ShipViewModel> getAttackerShipNames() {
        User attacker = modelMapper.map(userService.getPrincipal(), User.class);
        return shipRepository
                .findAllByUser(attacker)
                .stream()
                .map(ship -> modelMapper.map(ship, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewModel> getDefenderShipNames() {
        User defender = modelMapper.map(userService.getPrincipal(), User.class);
        return shipRepository
                .findAllByUserIsNot(defender)
                .stream()
                .map(ship -> modelMapper.map(ship, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    @Modifying
    public void battle(String attackerShipName, String defenderShipName) {
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

    @Override
    public void fire(String attackerName, String defenderName) {
        battle(attackerName, defenderName);
    }


}
