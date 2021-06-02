package spring.softunimusicdb.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import spring.softunimusicdb.model.entities.AlbumEntity;
import spring.softunimusicdb.model.service.AlbumServiceModel;
import spring.softunimusicdb.model.view.AlbumDetailedViewModel;
import spring.softunimusicdb.model.view.AlbumViewModel;
import spring.softunimusicdb.repository.AlbumRepository;
import spring.softunimusicdb.service.AlbumService;
import spring.softunimusicdb.service.ArtistService;
import spring.softunimusicdb.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final ArtistService artistService;
    private final UserService userService;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, ArtistService artistService, UserService userService) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.artistService = artistService;
        this.userService = userService;
    }

    @Override
    public List<AlbumViewModel> showAllView() {
        return albumRepository
                .findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, AlbumViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void create(AlbumServiceModel albumServiceModel) {
        AlbumEntity entity = modelMapper.map(albumServiceModel, AlbumEntity.class);
        entity.setArtistEntity(this.artistService.findByName(albumServiceModel.getArtistName()))
                .setUserEntity(this.userService.findByUsername(albumServiceModel.getUserName()));
        this.albumRepository.saveAndFlush(entity);
    }

    @Override
    public AlbumServiceModel findById(Long id) {
        return albumRepository.findById(id)
                .map(entity -> modelMapper.map(entity, AlbumServiceModel.class))
                .orElseThrow(IllegalStateException::new);
    }

    @Override
    public void delete(Long id) {
        albumRepository.deleteById(id);
    }
}
