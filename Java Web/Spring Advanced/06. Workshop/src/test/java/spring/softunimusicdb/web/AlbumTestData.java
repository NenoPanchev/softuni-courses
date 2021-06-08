package spring.softunimusicdb.web;

import spring.softunimusicdb.model.entities.AlbumEntity;
import spring.softunimusicdb.model.entities.ArtistEntity;
import spring.softunimusicdb.model.entities.UserEntity;
import spring.softunimusicdb.model.entities.enums.Genre;
import spring.softunimusicdb.repository.AlbumRepository;
import spring.softunimusicdb.repository.ArtistRepository;
import spring.softunimusicdb.repository.LogRepository;
import spring.softunimusicdb.repository.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;

public class AlbumTestData {
    private long testAlbumId;
    private UserRepository userRepository;
    private ArtistRepository artistRepository;
    private AlbumRepository albumRepository;
    private LogRepository logRepository;

    public AlbumTestData(UserRepository userRepository, ArtistRepository artistRepository, AlbumRepository albumRepository, LogRepository logRepository) {
        this.userRepository = userRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
        this.logRepository = logRepository;
    }

    public void init() {
        ArtistEntity artistEntity = new ArtistEntity()
                .setName("METALLICA")
                .setCareerInformation("Some info");
        artistEntity = artistRepository.save(artistEntity);

        UserEntity userEntity = new UserEntity()
                .setUsername("pesho")
                .setPassword("123")
                .setFullName("Peter Petrov")
                .setEmail("pesho@abv.bg");
        userEntity = userRepository.save(userEntity);

        AlbumEntity justiceForAll = new AlbumEntity()
                .setName("JUSTICE FOR ALL")
                .setImageUrl("https://upload.wikimedia.org/wikipedia/en/b/bd/Metallica_-_...And_Justice_for_All_cover.jpg")
                .setVideoUrl("_fKAsvJrFes")
                .setDescription("Sample")
                .setCopies(11L)
                .setPrice(BigDecimal.TEN)
                .setReleaseDate(LocalDate.of(1988, 3, 3).atStartOfDay(ZoneId.systemDefault()).toLocalDate())
                .setGenre(Genre.METAL)
                .setArtistEntity(artistEntity)
                .setUserEntity(userEntity);

        justiceForAll = albumRepository.save(justiceForAll);


        AlbumEntity masterOfPuppets = new AlbumEntity()
                .setName("MASTER OF PUPPETS")
                .setImageUrl("https://upload.wikimedia.org/wikipedia/en/b/bd/Metallica_-_...And_Justice_for_All_cover.jpg")
                .setVideoUrl("_fKAsvJrFes")
                .setDescription("Sample")
                .setCopies(111L)
                .setPrice(BigDecimal.TEN)
                .setReleaseDate(LocalDate.of(1988, 3, 3).atStartOfDay(ZoneId.systemDefault()).toLocalDate())
                .setGenre(Genre.METAL)
                .setArtistEntity(artistEntity)
                .setUserEntity(userEntity);

        masterOfPuppets = albumRepository.save(masterOfPuppets);

        testAlbumId = justiceForAll.getId();
    }

    void cleanUp() {
        logRepository.deleteAll();
        albumRepository.deleteAll();
        artistRepository.deleteAll();
        userRepository.deleteAll();
    }

    public long getTestAlbumId() {
        return testAlbumId;
    }
}
