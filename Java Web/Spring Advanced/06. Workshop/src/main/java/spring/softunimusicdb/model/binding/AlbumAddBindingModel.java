package spring.softunimusicdb.model.binding;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import spring.softunimusicdb.model.entities.enums.Genre;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumAddBindingModel {
    private String name;
    private String imageUrl;
    private String videoUrl;
    private String description;
    private Long copies;
    private BigDecimal price;
    private LocalDate releaseDate;
    private Genre genre;
    private String artistName;

    public AlbumAddBindingModel() {
    }

    @Length(min = 3, max = 20)
    public String getName() {
        return name;
    }

    public AlbumAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Length(min = 6)
    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumAddBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public AlbumAddBindingModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    @Length(min = 6)
    public String getDescription() {
        return description;
    }

    public AlbumAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @Min(0)
    @NotNull
    public Long getCopies() {
        return copies;
    }

    public AlbumAddBindingModel setCopies(Long copies) {
        this.copies = copies;
        return this;
    }

    @DecimalMin("0")
    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    public AlbumAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @PastOrPresent(message = "Release date cannot be in the future")
    @NotNull(message = "Enter a valid date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AlbumAddBindingModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    @NotNull
    public Genre getGenre() {
        return genre;
    }

    public AlbumAddBindingModel setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    @NotNull
    @NotEmpty
    public String getArtistName() {
        return artistName;
    }

    public AlbumAddBindingModel setArtistName(String artistName) {
        this.artistName = artistName;
        return this;
    }
}
