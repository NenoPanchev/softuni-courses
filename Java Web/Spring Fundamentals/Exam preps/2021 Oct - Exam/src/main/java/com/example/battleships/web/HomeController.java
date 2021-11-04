package com.example.battleships.web;

import com.example.battleships.model.binding.BattleBindingModel;
import com.example.battleships.service.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {
    private final ShipService shipService;

    public HomeController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/";
        }

        model.addAttribute("allShips", shipService.getAllShips());
        model.addAttribute("attackerShipNames", shipService.getAttackerShipNames());
        model.addAttribute("defenderShipNames", shipService.getDefenderShipNames());
        return "home";


    }

    @PostMapping("/home")
    public String fire(@RequestParam String attackerShipNames, @RequestParam String defenderShipNames) {
        shipService.fire(attackerShipNames, defenderShipNames);
        return "redirect:/home";
    }

    @ModelAttribute
    public BattleBindingModel battleBindingModel() {
        return new BattleBindingModel();
    }

}
