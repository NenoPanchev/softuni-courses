package exams.heroes.service.impl;

import exams.heroes.model.entity.Hero;
import exams.heroes.model.service.HeroServiceModel;
import exams.heroes.model.view.HeroViewModel;
import exams.heroes.repository.HeroRepository;
import exams.heroes.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroServiceImpl implements HeroService {
    private final HeroRepository heroRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public HeroServiceImpl(HeroRepository heroRepository, ModelMapper modelMapper) {
        this.heroRepository = heroRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<HeroViewModel> getAllHeroesOrderedByLevelDesc() {
        return this.heroRepository.findAllOrderByLevelDesc()
                .stream()
                .map(hero -> this.modelMapper.map(hero, HeroViewModel.class))
                .map(view -> {
                    String imgUrl = String.format("/img/%s.jpg", view.getAClass().name().toLowerCase());
                    view.setImgUrl(imgUrl);
                    return view;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void create(HeroServiceModel heroServiceModel) {
        this.heroRepository.saveAndFlush(this.modelMapper.map(heroServiceModel, Hero.class));
    }

    @Override
    public HeroViewModel findById(String id) {
        return this.heroRepository.findById(id)
                .map(hero -> this.modelMapper.map(hero, HeroViewModel.class))
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        this.heroRepository.deleteById(id);
    }

    @Override
    public HeroServiceModel post(HeroServiceModel heroServiceModel) {
        Hero hero = this.heroRepository.saveAndFlush(this.modelMapper.map(heroServiceModel, Hero.class));
        return this.modelMapper.map(hero, HeroServiceModel.class);
    }

}
