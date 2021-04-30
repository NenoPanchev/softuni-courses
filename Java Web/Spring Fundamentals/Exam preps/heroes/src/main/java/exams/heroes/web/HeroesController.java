package exams.heroes.web;

import exams.heroes.model.binding.HeroCreateBindingModel;
import exams.heroes.model.service.HeroServiceModel;
import exams.heroes.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/heroes")
public class HeroesController {
    private final HeroService heroService;
    private final ModelMapper modelMapper;

    @Autowired
    public HeroesController(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/create")
    public String create(Model model, HttpSession httpSession) {

        if (httpSession.getAttribute("user") == null) {
            return "redirect:/";
        }

        if (!model.containsAttribute("heroCreateBindingModel")) {
            model.addAttribute("heroCreateBindingModel", new HeroCreateBindingModel());
        }
        return "create-hero";
    }

    @PostMapping("/create")
    public String createConfirm(@Valid @ModelAttribute("heroCreateBindingModel")HeroCreateBindingModel heroCreateBindingModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("heroCreateBindingModel", heroCreateBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.heroCreateBindingModel", bindingResult);
            return "redirect:create";
        } else {
            this.heroService.create(this.modelMapper.map(heroCreateBindingModel, HeroServiceModel.class));
            return "redirect:/";
        }
    }

    @GetMapping("/details")
    public ModelAndView details(@RequestParam("id")String id, ModelAndView modelAndView, HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }

        modelAndView.addObject("hero", this.heroService.findById(id));
        modelAndView.setViewName("details-hero");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id, ModelAndView modelAndView, HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }

        modelAndView.addObject("hero", this.heroService.findById(id));
        modelAndView.setViewName("delete-hero");
        return modelAndView;
    }

    @GetMapping("/delete/confirm/{id}")
    public String deleteConfirm(@PathVariable("id") String id) {
        this.heroService.delete(id);
        return "redirect:/";
    }
}
