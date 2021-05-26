package spring.softunimusicdb.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import spring.softunimusicdb.model.view.AlbumViewModel;
import spring.softunimusicdb.repository.AlbumRepository;
import spring.softunimusicdb.service.AlbumService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AlbumViewModel> showAllView() {
        return albumRepository
                .findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, AlbumViewModel.class))
                .collect(Collectors.toList());
    }
}
