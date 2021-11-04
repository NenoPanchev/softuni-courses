package com.example.battleships.web;

import com.example.battleships.model.binding.BattleBindingModel;
import com.example.battleships.model.binding.ShipAddBindingModel;
import com.example.battleships.model.service.ShipServiceModel;
import com.example.battleships.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipController {
    private final ShipService shipService;
    private final ModelMapper modelMapper;

    public ShipController(ShipService shipService, ModelMapper modelMapper) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/";
        }
        return "ship-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ShipAddBindingModel shipAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("shipAddBindingModel", shipAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel", bindingResult);
            return "redirect:add";
        }

        shipService.addShip(modelMapper.map(shipAddBindingModel, ShipServiceModel.class));

        return "redirect:/";
    }

//    @PostMapping("/fire")
//    public String battle(BattleBindingModel battleBindingModel,
//                         BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()){
//            redirectAttributes.addFlashAttribute("battleBindingModel", battleBindingModel);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.battleBindingModel", bindingResult);
//
//            return "redirect:/";
//        }
//        String attackerName = battleBindingModel.getAttackerShipName();
//        String defenderName = battleBindingModel.getDefenderShipName();
//        shipService.battle(attackerName, defenderName);
//
//         return "redirect:/";
//    }

    @PostMapping("/fire")
    public String fire(@RequestParam("attackerName") String attackerName, @RequestParam("defenderName") String defenderName) {
        shipService.fire(attackerName, defenderName);
        return "redirect:/";
    }

    @ModelAttribute
    public BattleBindingModel battleBindingModel() {
        return new BattleBindingModel();
    }

    @ModelAttribute
    public ShipAddBindingModel shipAddBindingModel() {
        return new ShipAddBindingModel();
    }
}
