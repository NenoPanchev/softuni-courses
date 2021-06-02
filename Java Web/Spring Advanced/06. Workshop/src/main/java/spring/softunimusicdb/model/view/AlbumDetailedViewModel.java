package spring.softunimusicdb.model.view;

import spring.softunimusicdb.model.entities.enums.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumDetailedViewModel {
    private String name;
    private String imageUrl;
    private String videoUrl;
    private String description;
    private Long copies;
    private BigDecimal price;
    private LocalDate releaseDate;
    private Genre genre;
    private String artistName;

    public AlbumDetailedViewModel() {
    }

    public String getName() {
        return name;
    }

    public AlbumDetailedViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumDetailedViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public AlbumDetailedViewModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AlbumDetailedViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getCopies() {
        return copies;
    }

    public AlbumDetailedViewModel setCopies(Long copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumDetailedViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AlbumDetailedViewModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public AlbumDetailedViewModel setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public String getArtistName() {
        return artistName;
    }

    public AlbumDetailedViewModel setArtistName(String artistName) {
        this.artistName = artistName;
        return this;
    }
}
