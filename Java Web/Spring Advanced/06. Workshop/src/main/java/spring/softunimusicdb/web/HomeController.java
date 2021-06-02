package spring.softunimusicdb.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.softunimusicdb.service.AlbumService;
import spring.softunimusicdb.service.CarouselService;

@Controller
public class HomeController {

    private final CarouselService carouselService;
    private final AlbumService albumService;

    public HomeController(CarouselService carouselService, AlbumService albumService) {
        this.carouselService = carouselService;
        this.albumService = albumService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("firstImg", carouselService.firstImage());
        model.addAttribute("secondImg", carouselService.secondImage());
        model.addAttribute("thirdImg", carouselService.thirdImage());
        model.addAttribute("albums", albumService.showAllView());
        return "home";
    }
}
