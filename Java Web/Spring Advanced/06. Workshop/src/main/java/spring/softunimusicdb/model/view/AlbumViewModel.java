package spring.softunimusicdb.model.view;

import spring.softunimusicdb.model.entities.enums.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumViewModel {
    private Long id;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private LocalDate releaseDate;
    private Genre genre;
    private String artistName;

    public AlbumViewModel() {
    }

    public String getName() {
        return name;
    }

    public AlbumViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AlbumViewModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public AlbumViewModel setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public String getArtistName() {
        return artistName;
    }

    public AlbumViewModel setArtistName(String artistName) {
        this.artistName = artistName;
        return this;
    }

    public Long getId() {
        return id;
    }

    public AlbumViewModel setId(Long id) {
        this.id = id;
        return this;
    }
}
