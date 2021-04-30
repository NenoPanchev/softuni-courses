package exams.heroes.web.rest;

import exams.heroes.model.binding.HeroCreateBindingModel;
import exams.heroes.model.service.HeroServiceModel;
import exams.heroes.model.view.HeroViewModel;
import exams.heroes.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/heroes")
public class HeroesRestController {
    private final HeroService heroService;
    private final ModelMapper modelMapper;

    public HeroesRestController(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<HeroViewModel> getHeroes() {
        return this.heroService.getAllHeroesOrderedByLevelDesc();
    }

    @GetMapping("/{heroId}")
    public ResponseEntity<HeroViewModel> getHero(@PathVariable String heroId) {
        HeroViewModel hero = this.heroService.findById(heroId);
        if (hero == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(hero, HttpStatus.OK);
    }

//    @PostMapping
//    public void create() {
//        this.heroService.create(new HeroServiceModel("Restcho", Class.WARRIOR, 69));
//    }

    @PostMapping
    public ResponseEntity<HeroServiceModel> create(
            UriComponentsBuilder ucBuilder,
            @RequestBody HeroServiceModel serviceModel
    ) {
        HeroServiceModel newHero = this.heroService.post(serviceModel);
        return ResponseEntity.
                created(ucBuilder.path("/heroes/{heroId}").buildAndExpand(newHero.getId()).toUri()).build();
    }

    @DeleteMapping("/{heroId}")
    public ResponseEntity<HeroServiceModel> delete(@PathVariable String  heroId) {
        this.heroService.delete(heroId);
        return ResponseEntity.noContent().build();
    }

}
