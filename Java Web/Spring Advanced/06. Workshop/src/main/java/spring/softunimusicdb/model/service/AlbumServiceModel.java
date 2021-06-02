package spring.softunimusicdb.model.service;

import spring.softunimusicdb.model.entities.enums.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumServiceModel extends BaseServiceModel {
    private String name;
    private String imageUrl;
    private String videoUrl;
    private String description;
    private Long copies;
    private BigDecimal price;
    private LocalDate releaseDate;
    private Genre genre;
    private String artistName;
    private String userName;

    public AlbumServiceModel() {
    }

    public String getName() {
        return name;
    }

    public AlbumServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public AlbumServiceModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AlbumServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getCopies() {
        return copies;
    }

    public AlbumServiceModel setCopies(Long copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AlbumServiceModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public AlbumServiceModel setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public String getArtistName() {
        return artistName;
    }

    public AlbumServiceModel setArtistName(String artistName) {
        this.artistName = artistName;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public AlbumServiceModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }
}
