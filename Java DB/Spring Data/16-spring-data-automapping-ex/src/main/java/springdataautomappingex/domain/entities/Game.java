package springdataautomappingex.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "games")
@NoArgsConstructor
@Getter
@Setter
public class Game extends BaseEntity{
    @Column(unique = true)
    private String title;
    private String trailer;
    @Column(name = "image_thumbnail_url")
    private String imageThumbnailURL;
    private double size;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;

    @Override
    public String toString() {
        return String.format("Title: %s%nPrice: %.2f%nDescription: %s%nRelease date: %s%n",
                this.title,
                this.price,
                this.description,
                this.releaseDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
}
