package exams.heroes.service;

import exams.heroes.model.service.HeroServiceModel;
import exams.heroes.model.view.HeroViewModel;

import java.util.List;

public interface HeroService {
    List<HeroViewModel> getAllHeroesOrderedByLevelDesc();

    void create(HeroServiceModel heroServiceModel);
    HeroViewModel findById(String id);
    void delete(String id);
    HeroServiceModel post(HeroServiceModel heroServiceModel);
}
