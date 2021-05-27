package spring.eventsandcaching.transactions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "birds")
public class BirdEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, updatable = false)
  private long id;

  @Column(name = "breed", nullable = false)
  private String breed;

  public long getId() {
    return id;
  }

  public BirdEntity setId(long id) {
    this.id = id;
    return this;
  }

  public String getBreed() {
    return breed;
  }

  public BirdEntity setBreed(String breed) {
    this.breed = breed;
    return this;
  }
}
