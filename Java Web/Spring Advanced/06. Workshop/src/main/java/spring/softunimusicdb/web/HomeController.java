package spring.softunimusicdb.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.softunimusicdb.service.CarouselService;

@Controller
public class HomeController {

    private final CarouselService carouselService;

    public HomeController(CarouselService carouselService) {
        this.carouselService = carouselService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("firstImg", carouselService.firstImage());
        model.addAttribute("secondImg", carouselService.firstImage());
        model.addAttribute("thirdImg", carouselService.firstImage());
        return "home";
    }
}
