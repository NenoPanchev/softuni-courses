package spring.softunimusicdb.model.entities;

import spring.softunimusicdb.model.entities.enums.Genre;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "albums")
public class AlbumEntity extends BaseEntity{
    private String name;
    private String imageUrl;
    private String videoUrl;
    private String description;
    private Integer copies;
    private BigDecimal price;
    private Instant releaseDate;
    private Genre genre;
    private ArtistEntity artistEntity;
    private UserEntity userEntity;

    public AlbumEntity() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public AlbumEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column(nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public AlbumEntity setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    @Column(nullable = false, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public AlbumEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(nullable = false)
    public Integer getCopies() {
        return copies;
    }

    public AlbumEntity setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public AlbumEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Column(nullable = false)
    public Instant getReleaseDate() {
        return releaseDate;
    }

    public AlbumEntity setReleaseDate(Instant releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public Genre getGenre() {
        return genre;
    }

    public AlbumEntity setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    @ManyToOne
    public ArtistEntity getArtistEntity() {
        return artistEntity;
    }

    public AlbumEntity setArtistEntity(ArtistEntity artistEntity) {
        this.artistEntity = artistEntity;
        return this;
    }

    @ManyToOne
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public AlbumEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }
}
