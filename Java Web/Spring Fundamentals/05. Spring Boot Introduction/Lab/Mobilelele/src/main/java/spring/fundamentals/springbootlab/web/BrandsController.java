package spring.fundamentals.springbootlab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.fundamentals.springbootlab.repositories.BrandRepository;

@Controller
@RequestMapping("/brands")
public class BrandsController {
    private final BrandRepository brandRepository;

    @Autowired
    public BrandsController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping("/all")
    public String getAllBrands(Model model) {
        model.addAttribute("brands", this.brandRepository.findAll());
        return "brands";
    }
}
