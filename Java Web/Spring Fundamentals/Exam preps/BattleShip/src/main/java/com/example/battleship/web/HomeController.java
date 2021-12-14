package com.example.battleship.web;

import com.example.battleship.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final ShipService shipService;
    private final ModelMapper modelMapper;

    public HomeController(ShipService shipService, ModelMapper modelMapper) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }


    @GetMapping
    public String index(HttpSession httpSession) {
        if  (httpSession.getAttribute("user") != null) {
            return "redirect:home";
        }
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession httpSession) {
        if  (httpSession.getAttribute("user") == null) {
            return "redirect:/";
        }
        model.addAttribute("allShips", shipService.getAllShips());
        model.addAttribute("allAttackerShipNames", shipService.getAllAttackerShipNames());
        model.addAttribute("allDefenderShipNames", shipService.getAllDefenderShipNames());
        return "home";
    }

}
