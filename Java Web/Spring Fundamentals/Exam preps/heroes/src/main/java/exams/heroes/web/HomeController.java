package exams.heroes.web;

import exams.heroes.model.service.UserServiceModel;
import exams.heroes.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final HeroService heroService;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeController(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView, HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            modelAndView.setViewName("index");
        } else {
            UserServiceModel userServiceModel = (UserServiceModel) httpSession.getAttribute("user");
            modelAndView.addObject("loginName", userServiceModel.getUsername());
            modelAndView.addObject("heroes", this.heroService.getAllHeroesOrderedByLevelDesc());
            modelAndView.setViewName("home");
        }


        return modelAndView;
    }
}
