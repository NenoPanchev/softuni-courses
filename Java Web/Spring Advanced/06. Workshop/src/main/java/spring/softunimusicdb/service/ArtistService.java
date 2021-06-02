package spring.softunimusicdb.service;

import spring.softunimusicdb.model.entities.ArtistEntity;

import java.util.List;

public interface ArtistService {
    void seedArtists();
    List<String> findAllArtistNames();
    ArtistEntity findByName(String name);
}
