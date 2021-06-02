package spring.softunimusicdb.web;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.softunimusicdb.model.binding.AlbumAddBindingModel;
import spring.softunimusicdb.model.service.AlbumServiceModel;
import spring.softunimusicdb.model.view.AlbumDetailedViewModel;
import spring.softunimusicdb.service.AlbumService;
import spring.softunimusicdb.service.ArtistService;

import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final ModelMapper modelMapper;
    private final AlbumService albumService;
    private final ArtistService artistService;

    public AlbumController(ModelMapper modelMapper, AlbumService albumService, ArtistService artistService) {
        this.modelMapper = modelMapper;
        this.albumService = albumService;
        this.artistService = artistService;
    }

    @ModelAttribute("albumAddBindingModel")
    public AlbumAddBindingModel createBindingModel() {
        return new AlbumAddBindingModel();
    }

    @GetMapping("/add")
    public String addAlbum(Model model) {
        model.addAttribute("artists", artistService.findAllArtistNames());
        return "add-album";
    }

    @PostMapping("/add")
    public String addAlbumConfirm(@Valid AlbumAddBindingModel albumAddBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                  @AuthenticationPrincipal UserDetails principal) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("albumAddBindingModel", albumAddBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.albumAddBindingModel", bindingResult);

            return "redirect:add";
        }

        AlbumServiceModel albumServiceModel = modelMapper.map(albumAddBindingModel, AlbumServiceModel.class);
        albumServiceModel.setUserName(principal.getUsername());
        this.albumService.create(albumServiceModel);
        return "redirect:/home";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        AlbumDetailedViewModel detailedViewModel = modelMapper.map(albumService.findById(id), AlbumDetailedViewModel.class);
        model.addAttribute("album", detailedViewModel);
        return "details";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        albumService.delete(id);
        return "redirect:/home";
    }
}
