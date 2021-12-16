package com.example.december2021exam.web;

import com.example.december2021exam.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final ModelMapper modelMapper;
    private final ProductService productService;

    public HomeController(ModelMapper modelMapper, ProductService productService) {
        this.modelMapper = modelMapper;
        this.productService = productService;
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
        model.addAttribute("foods", productService.findAllFoodProducts());
        model.addAttribute("drinks", productService.findAllDrinkProducts());
        model.addAttribute("households", productService.findAllHouseholdProducts());
        model.addAttribute("others", productService.findAllOtherProducts());
        model.addAttribute("sum", productService.sumOfAllPrices());
        return "home";
    }

}
