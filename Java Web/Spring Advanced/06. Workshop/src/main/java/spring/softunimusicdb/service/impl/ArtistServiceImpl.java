package spring.softunimusicdb.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import spring.softunimusicdb.model.dtos.ArtistSeedDto;
import spring.softunimusicdb.model.entities.ArtistEntity;
import spring.softunimusicdb.repository.ArtistRepository;
import spring.softunimusicdb.service.ArtistService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final Resource artistsFile;
    private final Gson gson;
    private final ArtistRepository artistRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ArtistServiceImpl(@Value("classpath:init/artists.json") Resource artistsFile,
                             Gson gson,
                             ArtistRepository artistRepository, ModelMapper modelMapper) {
        this.artistsFile = artistsFile;
        this.gson = gson;
        this.artistRepository = artistRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedArtists() {
        if (artistRepository.count() == 0) {
            try {
                ArtistSeedDto[] artistEntities =
                        gson.fromJson(Files.readString(
                                Path.of(artistsFile.getURI())), ArtistSeedDto[].class);

                Arrays.stream(artistEntities)
                        .map(dto -> modelMapper.map(dto, ArtistEntity.class))
                        .forEach(artistRepository::save);
            } catch (IOException e) {
                throw new IllegalStateException("Cannot seed artists");
            }
        }
    }
}
