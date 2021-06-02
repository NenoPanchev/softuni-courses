package spring.softunimusicdb.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
public class LogEntity extends BaseEntity{
    private UserEntity userEntity;
    private AlbumEntity albumEntity;
    private String action;
    private LocalDateTime dateTime;

    public LogEntity() {
    }

    @ManyToOne
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public LogEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    @ManyToOne
    public AlbumEntity getAlbumEntity() {
        return albumEntity;
    }

    public LogEntity setAlbumEntity(AlbumEntity albumEntity) {
        this.albumEntity = albumEntity;
        return this;
    }

    @Column(nullable = false)
    public String getAction() {
        return action;
    }

    public LogEntity setAction(String action) {
        this.action = action;
        return this;
    }

    @Column(nullable = false)
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public LogEntity setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }
}
